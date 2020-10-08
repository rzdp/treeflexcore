package com.rzdp.treeflexconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TreeflexConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreeflexConfigServerApplication.class, args);
    }

}
