package com.vecinet.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGatewayController {

    @GetMapping("/api-gateway")
    public String apiGateway() {
        return "Api Gateway";
    }


    @GetMapping()
    public String hello() {
        return "Hello from Api Gateway!";
    }


}
