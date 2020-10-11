package com.rzdp.treeflexauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TreeflexAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeflexAuthorizationServerApplication.class, args);
    }

}
