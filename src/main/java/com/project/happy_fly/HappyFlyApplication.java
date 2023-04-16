package com.project.happy_fly;

import com.project.happy_fly.configuration.DatabaseData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DatabaseData.class)
public class HappyFlyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HappyFlyApplication.class, args);
    }

}
