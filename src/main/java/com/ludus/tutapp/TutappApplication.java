package com.ludus.tutapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TutappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutappApplication.class, args);
    }

    @Bean
}
