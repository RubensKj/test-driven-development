package com.study.tdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StudyingTddApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyingTddApplication.class, args);
    }

}
