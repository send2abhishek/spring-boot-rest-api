package com.learn.springboot.restapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@SpringBootApplication
@PropertySource("classpath:config/app.properties")

public class RestApiApplication {

    public static void main(String[] args) {

        log.info("spring application started..........={}", 3001);

        SpringApplication.run(RestApiApplication.class, args);
    }


}
