package com.example.schoolapigroupone.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HealthController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
