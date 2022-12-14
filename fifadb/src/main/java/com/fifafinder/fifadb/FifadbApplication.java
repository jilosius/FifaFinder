package com.fifafinder.fifadb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fifafinder.fifadb.entities")
@EnableAutoConfiguration
public class FifadbApplication {

    public static void main(String[] args) {
        SpringApplication.run(FifadbApplication.class, args);
    }

}

