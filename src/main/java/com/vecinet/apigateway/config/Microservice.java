package com.vecinet.apigateway.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Microservice {

    // MS-VECINET-AUTH CONFIG
    @Value("${ms-vecinet.auth.url}")
    private String msVecinetAuthUrl;
    @Value("${ms-vecinet.auth.context-path}")
    private String msVecinetAuthContextPath;

    // MS-VECINET-POST CONFIG
    @Value("${ms-vecinet.post.url}")
    private String msVecinetPostUrl;
    @Value("${ms-vecinet.post.context-path}")
    private String msVecinetPostPortContextPath;

    @PostConstruct
    public void init(){
        System.out.println("MS-VECINET-AUTH URL: " + msVecinetAuthUrl);
        System.out.println("MS-VECINET-AUTH CONTEXT-PATH: " + msVecinetAuthContextPath);
        System.out.println("MS-VECINET-POST URL: " + msVecinetPostUrl);
        System.out.println("MS-VECINET-POST CONTEXT-PATH: " + msVecinetPostPortContextPath);
    }

}
