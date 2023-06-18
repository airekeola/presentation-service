package edu.miu.swa.presentationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PresentationServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(PresentationServiceApplication.class, args);
    }

}
