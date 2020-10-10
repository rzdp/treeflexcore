package com.rzdp.treeflexaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableFeignClients
@EnableResourceServer
public class TreeflexAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeflexAccountServiceApplication.class, args);
    }

}
