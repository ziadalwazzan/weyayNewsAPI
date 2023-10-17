package com.example.weyayNewsAPI.remote

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.web.client.RestTemplate

class NewsApiHttpClient ( private val restTemplate: RestTemplate ) : NewsApiClientInterface {

    @Value("\${weyayNewsAPI.base-url}")
    private lateinit var baseUrl: String
    @Value("\${weyayNewsAPI.news-api-key}")
    lateinit var apiKey: String

    override fun requestTopHeadlines(country : String): TopHeadlinesDTO {
        // Build HTTP Request
        val headers = HttpHeaders()
        headers.add("X-Api-Key", apiKey)

        val response : ResponseEntity<TopHeadlinesDTO> = restTemplate.exchange(
            "$baseUrl/top-headlines?country=$country",
            HttpMethod.GET,
            HttpEntity<String>(headers),
            TopHeadlinesDTO::class.java)

        return response.body!!
    }
    override fun requestSources(): SourcesDTO{
        // NewsApi HTTP Request
        val headers = HttpHeaders()
        headers.add("X-Api-Key", apiKey)

        val response : ResponseEntity<SourcesDTO> = restTemplate.exchange(
            "$baseUrl/top-headlines/sources",
            HttpMethod.GET,
            HttpEntity<String>(headers),
            SourcesDTO::class.java)

        // map, count, and return SourceDTO
        val sDTO : SourcesDTO = response.body!!
        sDTO.totalResults = response.body?.sources?.size

        return sDTO
    }
    override fun requestFileDownload(fileUrl: String): ByteArray{
        // Request file
        val tempData : ByteArray = "Feature was descoped :)".toByteArray()
        val temp : ResponseEntity<ByteArray> = ResponseEntity(tempData, HttpStatus.ACCEPTED)

        return temp.body!!
    }
}