package com.vecinet.apigateway.config;

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

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( EMicroservice.MS_VECINET_AUTH.name() , getRoute( EMicroservice.MS_VECINET_AUTH ) )
                .build();
    }

    public Function<PredicateSpec, Buildable<Route>> getRoute( EMicroservice microservice ) {
        return ps -> ps.path( microservice.getPath() ).uri( microservice.getUri() );
    }

}
