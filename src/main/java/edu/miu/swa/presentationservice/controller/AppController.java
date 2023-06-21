package edu.miu.swa.presentationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class AppController {
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    @GetMapping()
    public String get(){
        logger.info(" GET REQUEST ");
        String message = "Presentation service endpoint";
        logger.info("RESPONSE "+message);
        return message;
    }
}
