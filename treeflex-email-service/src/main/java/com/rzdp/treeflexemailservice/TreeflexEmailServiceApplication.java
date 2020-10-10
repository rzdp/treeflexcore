package com.rzdp.treeflexemailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class TreeflexEmailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeflexEmailServiceApplication.class, args);
    }

}
