package com.ranv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ManualAdviserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManualAdviserApplication.class, args);
    }

}
