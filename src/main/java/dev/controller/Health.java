package dev.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class Health {
    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of(
                "status", "UP",
                "code", 200
        );
    }

    @GetMapping
    public Map<String, Object> index() {
        return Map.of(
                "status", "UP",
                "code", 200
        );
    }
}
