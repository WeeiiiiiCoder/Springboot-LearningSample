package com.lazyboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class C411Application {
    public static void main(String[] args) {
        SpringApplication.run(C411Application.class, args);
    }
}
