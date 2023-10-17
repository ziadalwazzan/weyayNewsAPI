package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.remote.NewsApiHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class AppConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun newsApiClient(): NewsApiHttpClient {
        return NewsApiHttpClient(restTemplate())
    }
}