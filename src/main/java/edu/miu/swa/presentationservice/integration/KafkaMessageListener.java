package edu.miu.swa.presentationservice.integration;

import edu.miu.swa.presentationservice.service.CsvWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageListener {


    private final CsvWriter csvWriter;

    @KafkaListener(topics = "#{T(java.util.Arrays).asList('${ably-ripped-kafka-topics}')}", groupId = "ps")
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        System.out.println("Received message from topic " + topic + ": " + message);

        try {
            // Process the received message
            csvWriter.writeToCsv(topic + ".csv", topic, message);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Could not properly write to file this Object {}", message);
        }
    }
}
