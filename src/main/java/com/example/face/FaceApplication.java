package com.example.face;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan("com.example.face")
public class FaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaceApplication.class, args);
    }

}
