package com.nitish.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Value("${app.subdomain}")
    private String fromProperties;

    @GetMapping
    public String index(){
        return "Hello Spring Boot app.subdomain="+fromProperties;
    }

}
