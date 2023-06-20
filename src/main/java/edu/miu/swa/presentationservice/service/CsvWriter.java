package edu.miu.swa.presentationservice.service;

import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author bazz, chunkingz
 * Jun 18 2023
 * 00:33
 */

@Service
public class CsvWriter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void writeToCsv(String csv, String topicName, String data) {
        String[] HEADERS = {"Timestamp", topicName};
        LocalDateTime now = LocalDateTime.now();


        try {
            Path path = Path.of(csv);
            boolean fileExists = Files.exists(path);

            if (!fileExists) {
                Files.writeString(path, String.join(",", HEADERS) + "\n");
            }

            String row = now.format(FORMATTER) + "," + data + "\n";
            Files.writeString(path, row, StandardOpenOption.APPEND);


            System.out.println("Data has been written to " + csv);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
        }
    }
}
