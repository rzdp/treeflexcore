package com.rzdp.treeflexpaymentgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class TreeflexPaymentGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeflexPaymentGatewayServiceApplication.class, args);
    }

}
