package com.ludus.tutapp;

import com.ludus.tutapp.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TutappApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TutappApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean(name = "SpringApplicationContext")
    public SpringApplicationContext springApplicationContext(){
        return new SpringApplicationContext();
    }
    @Bean(name = "AppProperties")
    public AppProperties appProperties(){
        return new AppProperties();
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TutappApplication.class);
    }

}





























