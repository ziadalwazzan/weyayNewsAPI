package com.example.weyayNewsAPI.remote

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO


interface NewsApiClientInterface {
    fun requestTopHeadlines(country : String): TopHeadlinesDTO
    fun requestSources(): SourcesDTO
    fun requestFileDownload(fileUrl: String): ByteArray
}