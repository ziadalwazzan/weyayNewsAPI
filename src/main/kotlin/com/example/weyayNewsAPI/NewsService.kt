package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import com.example.weyayNewsAPI.remote.NewsApiClientInterface

import org.springframework.stereotype.Service


@Service
class NewsService( private val client : NewsApiClientInterface) {
    fun fetchTopHeadlines(country: String): TopHeadlinesDTO {
        return client.requestTopHeadlines(country)
    }

    fun fetchSources(): SourcesDTO {
        return client.requestSources()
    }

    fun downloadFile(downloadUrl : String): ByteArray {
        return client.requestFileDownload(downloadUrl)
    }
}
