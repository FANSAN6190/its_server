package com.its.wps;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class WpsApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("PG_HOST", Objects.requireNonNull(dotenv.get("PG_HOST")));
        System.setProperty("PG_PWD", Objects.requireNonNull(dotenv.get("PG_PWD")));
        SpringApplication.run(WpsApplication.class, args);

    }

}
