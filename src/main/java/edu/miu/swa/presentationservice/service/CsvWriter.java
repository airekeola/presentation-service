package edu.miu.swa.presentationservice.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author bazz
 * Jun 18 2023
 * 00:33
 */
public class CsvWriter {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void writeToCsv(String csv, String topicName, String data) {
        String[] HEADERS = {"Timestamp", topicName};
        LocalDateTime now = LocalDateTime.now();


        try {

            boolean fileExists = Files.exists(Path.of(csv));

            if (!fileExists) {
                Files.writeString(Path.of(csv), String.join(",", HEADERS) + "\n");
            }

            String row = now.format(FORMATTER) + "," + data + "\n";
            Files.writeString(Path.of(csv), row, StandardOpenOption.APPEND);


            System.out.println("Data has been written to " + csv);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the CSV file: " + e.getMessage());
        }
    }
}
}
