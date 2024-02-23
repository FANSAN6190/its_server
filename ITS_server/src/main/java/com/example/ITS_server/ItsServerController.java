package com.example.ITS_server;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ItsServerController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String hello() {
        return "This is ITS server API.";
    }

    @GetMapping("/ping")
    public String ping(@RequestParam(value = "message", defaultValue = "default") String name) {
        return String.format("Check : %s , Received : %s", counter.incrementAndGet(), name);
    }
}
