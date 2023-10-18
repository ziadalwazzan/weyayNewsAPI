package com.example.weyayNewsAPI.remote

import com.example.weyayNewsAPI.NewsController
import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.web.client.RestTemplate

class NewsApiHttpClient ( private val restTemplate: RestTemplate ) : NewsApiClientInterface {

    private var LOGGER: Logger = LoggerFactory.getLogger(NewsController::class.java)

    @Value("\${weyayNewsAPI.base-url}")
    private lateinit var baseUrl: String
    @Value("\${weyayNewsAPI.news-api-key}")
    lateinit var apiKey: String

    override fun requestTopHeadlines(country : String): TopHeadlinesDTO {
        LOGGER.info("Inside of NewsApiHttpClient.requestTopHeadlines() with country=$country")
        // Build HTTP Request
        val headers = HttpHeaders()
        headers.add("X-Api-Key", apiKey)

        val response : ResponseEntity<TopHeadlinesDTO> = restTemplate.exchange(
            "$baseUrl/top-headlines?country=$country",
            HttpMethod.GET,
            HttpEntity<String>(headers),
            TopHeadlinesDTO::class.java)

        LOGGER.info("RESPONSE HEADERS: {}", response.headers)
        LOGGER.info("RESPONSE BODY - TopHeadlinesDTO: [ status: ${response.body?.status} / totalResults: ${response.body?.totalResults} ]")

        return response.body!!
    }
    override fun requestSources(): SourcesDTO{
        LOGGER.info("Inside of NewsApiHttpClient.requestSources()")
        // NewsApi HTTP Request
        val headers = HttpHeaders()
        headers.add("X-Api-Key", apiKey)

        val response : ResponseEntity<SourcesDTO> = restTemplate.exchange(
            "$baseUrl/top-headlines/sources",
            HttpMethod.GET,
            HttpEntity<String>(headers),
            SourcesDTO::class.java)

        LOGGER.info("RESPONSE HEADERS: {}", response.headers)
        LOGGER.info("RESPONSE BODY - SourcesDTO: [ status: ${response.body?.status} / totalResults: ${response.body?.totalResults} ]")

        // map, count, and return SourceDTO
        val sDTO : SourcesDTO = response.body!!
        sDTO.totalResults = response.body?.sources?.size

        LOGGER.info("SourcesDTO: [ status: ${sDTO.status} / totalResults: ${sDTO.totalResults} ]")

        return sDTO
    }
    override fun requestFileDownload(fileUrl: String): ByteArray{
        LOGGER.info("Inside of NewsApiHttpClient.requestFileDownload()")
        // Request file
        val tempData : ByteArray = "Feature was descoped :)".toByteArray()
        val temp : ResponseEntity<ByteArray> = ResponseEntity(tempData, HttpStatus.ACCEPTED)

        return temp.body!!
    }
}