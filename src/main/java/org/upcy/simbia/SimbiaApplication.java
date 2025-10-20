package org.upcy.simbia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SimbiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimbiaApplication.class, args);
    }

}
