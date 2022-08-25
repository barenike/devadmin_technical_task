package com.example.devadmin_technical_task.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
