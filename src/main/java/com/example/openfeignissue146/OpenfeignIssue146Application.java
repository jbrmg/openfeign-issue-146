package com.example.openfeignissue146;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignIssue146Application {

    public static void main(String[] args) {
        SpringApplication.run(OpenfeignIssue146Application.class, args);
    }

}
