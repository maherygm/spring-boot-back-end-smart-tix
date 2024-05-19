package com.mahery.backendjavasmarttix;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BackEndJavaSmartTixApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackEndJavaSmartTixApplication.class, args);
    }

}
