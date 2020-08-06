package com.example.face;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceApplication.class, args);
    }

}
