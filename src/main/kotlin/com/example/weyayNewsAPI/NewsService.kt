package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import com.example.weyayNewsAPI.models.Article
import com.example.weyayNewsAPI.models.Source
import com.fasterxml.jackson.databind.ObjectMapper

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder


@Service
class NewsService(
    private val restTemplate: RestTemplate,
    @Value("\${weyayNewsAPI.base-url}") private val baseUrl: String,
    @Value("\${weyayNewsAPI.news-api-key}") private val apiKey: String
    )
{
    fun fetchTopHeadlines(country: String): ResponseEntity<TopHeadlinesDTO> {
        // Build HTTP Request
        val uri = "$baseUrl/top-headlines?country=$country"
        val headers = HttpHeaders()
        headers.add("X-Api-Key", apiKey)
        val requestEntity = HttpEntity<String>(headers)

        return restTemplate.exchange(uri, HttpMethod.GET, requestEntity, TopHeadlinesDTO::class.java)
    }

    fun fetchSources(): ResponseEntity<SourcesDTO> {
        // Build HTTP Request
        val uri = "$baseUrl/top-headlines/sources"
        val headers = HttpHeaders()
        headers.add("X-Api-Key", apiKey)
        val requestEntity = HttpEntity<String>(headers)

        return restTemplate.exchange(uri, HttpMethod.GET, requestEntity, SourcesDTO::class.java)
    }

    fun downloadFile(downloadUrl : String): ResponseEntity<ByteArray> {
        val tempData : ByteArray = "sldknvcoureibfklnsafclese".toByteArray()
        val temp : ResponseEntity<ByteArray> = ResponseEntity(tempData, HttpStatus.ACCEPTED)
        return temp
    }

}
