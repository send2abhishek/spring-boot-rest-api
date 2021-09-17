package com.learn.springboot.restapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {

        log.info("spring application started..........={}",3001);

        SpringApplication.run(RestApiApplication.class, args);
    }

}
