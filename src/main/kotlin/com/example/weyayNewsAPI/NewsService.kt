package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import com.example.weyayNewsAPI.remote.NewsApiClientInterface
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Service


@Service
class NewsService( private val client : NewsApiClientInterface) {
    private final var LOGGER: Logger = LoggerFactory.getLogger(NewsController::class.java)
    fun fetchTopHeadlines(country: String): TopHeadlinesDTO {
        LOGGER.info("Inside of NewsService.fetchTopHeadlines() with country=$country")
        return client.requestTopHeadlines(country)
    }

    fun fetchSources(): SourcesDTO {
        LOGGER.info("Inside of NewsService.getSources()")
        return client.requestSources()
    }

    fun downloadFile(downloadUrl : String): ByteArray {
        LOGGER.info("Inside of NewsService.getSources()")
        return client.requestFileDownload(downloadUrl)
    }
}
