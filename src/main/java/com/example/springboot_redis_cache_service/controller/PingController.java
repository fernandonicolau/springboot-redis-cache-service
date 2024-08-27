package com.example.springboot_redis_cache_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(value = "/ping")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Ping", HttpStatus.OK);
    }
}
