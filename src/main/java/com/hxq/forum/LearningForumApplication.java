package com.hxq.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.annotation.ServletSecurity;

@SpringBootApplication
public class LearningForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningForumApplication.class, args);
    }

}
