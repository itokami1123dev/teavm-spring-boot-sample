package com.example.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @RequestMapping(value = "/hello")
    String hello() {
        return "Hello ApiController!";
    }
}