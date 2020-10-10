package com.rzdp.treeflexemailservice.controller;

import com.rzdp.treeflexemailservice.model.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/v1/email")
    public MessageResponse sendEmail() {
        log.info("Will start sending email notification");
        log.info("Email: sample@sample.com");
        log.info("Subject: Hello");
        log.info("Message: Hello World");
        log.info("Email sent successfully");
        return new MessageResponse("Email sent successfully");
    }
}
