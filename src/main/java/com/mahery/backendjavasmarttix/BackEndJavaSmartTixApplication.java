package com.mahery.backendjavasmarttix;

import com.mahery.backendjavasmarttix.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
public class BackEndJavaSmartTixApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackEndJavaSmartTixApplication.class, args);
    }

}
