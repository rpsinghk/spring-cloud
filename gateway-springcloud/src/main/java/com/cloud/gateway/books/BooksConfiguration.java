package com.cloud.gateway.books;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BooksConfiguration.class)
public class BooksConfiguration {
	  @Bean
	  public RouteLocator consumerProxyRouting(RouteLocatorBuilder builder, BooksDestination booksDestination) {
	    return builder.routes()
	            .route(r -> r.path("/books").and().method("POST").uri(booksDestination.getBooksServiceUrl()))
	            .route(r -> r.path("/books").and().method("PUT").uri(booksDestination.getBooksServiceUrl()))
	            .build();
	  }

}
