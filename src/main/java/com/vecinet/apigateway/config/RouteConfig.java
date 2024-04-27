package com.vecinet.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class RouteConfig {


    @Autowired
    private Microservice microservice;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( microservice.getMsVecinetAuthContextPath() , getRoute( microservice.getMsVecinetAuthContextPath() ,microservice.getMsVecinetAuthUrl()) )
                .route( microservice.getMsVecinetPostPortContextPath() , getRoute( microservice.getMsVecinetPostPortContextPath(), microservice.getMsVecinetPostUrl()) )
                .build();
    }

    public Function<PredicateSpec, Buildable<Route>> getRoute( String contextPath, String url ) {
        return ps -> ps.path( getPath(contextPath) ).uri( url );
    }

    private String getPath(String microservice){
        return "/api/" + microservice + "/**";
    }

}
