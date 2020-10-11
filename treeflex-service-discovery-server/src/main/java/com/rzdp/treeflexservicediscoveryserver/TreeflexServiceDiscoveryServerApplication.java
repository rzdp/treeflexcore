package com.rzdp.treeflexservicediscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TreeflexServiceDiscoveryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeflexServiceDiscoveryServerApplication.class, args);
    }

}
