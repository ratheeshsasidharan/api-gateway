package com.rs.ecommerce.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/products/**")
                        .filters(f -> f.addRequestHeader("Auth","Auth123")
                        //        .addRequestParameter("newParam","newParamVal")
                        )
                        .uri("lb://product-service"))
                .build();

    }
}
