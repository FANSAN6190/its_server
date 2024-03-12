package com.its.wsms;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Objects;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WsmsApplication {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("PG_HOST", Objects.requireNonNull(dotenv.get("PG_HOST")));
        System.setProperty("PG_PWD", Objects.requireNonNull(dotenv.get("PG_PWD")));

        SpringApplication.run(WsmsApplication.class, args);
    }

}
