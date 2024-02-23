package com.example.ITS_server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ItsServerController {
    @GetMapping("/")
    public String hello() {
        return "This is ITS server API.";
    }
}
