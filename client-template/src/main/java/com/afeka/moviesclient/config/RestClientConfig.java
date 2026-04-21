package com.afeka.moviesclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * יוצר את ה-RestClient bean עם ה-baseUrl מה-application.properties.
 * הקובץ הזה מוכן ומלא — אין צורך לשנות אותו.
 */
@Configuration
public class RestClientConfig {

    @Value("${movies.api.base-url}")
    private String baseUrl;

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .baseUrl(baseUrl)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
