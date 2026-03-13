package com.capgemini.cachepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CachepracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachepracticeApplication.class, args);
    }
}
