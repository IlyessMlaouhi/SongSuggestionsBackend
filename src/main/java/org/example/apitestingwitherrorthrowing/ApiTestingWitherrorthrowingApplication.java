package org.example.apitestingwitherrorthrowing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ApiTestingWitherrorthrowingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestingWitherrorthrowingApplication.class, args);
    }

}
