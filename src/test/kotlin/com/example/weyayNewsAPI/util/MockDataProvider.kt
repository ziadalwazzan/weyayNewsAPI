package com.example.weyayNewsAPI.util

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import com.example.weyayNewsAPI.models.Article
import com.example.weyayNewsAPI.models.Source

class MockDataProvider {
    fun getMockHeadlines(): TopHeadlinesDTO {
        val mockArticle = Article(
            source = Source("weyay", "Weyay"),
            author = "Ziad AlWazzan",
            title = "Mock Article 1",
            description = "",
            url = "https://www.google.com",
            urlToImage = "https://www.google.com/images",
            publishedAt = "2023-10-14T06:31:00Z",
            content = "some content"
        )
        val status = "ok"
        val totalResults = 1
        val articles : Array<Article> = arrayOf(mockArticle)

        val mockData = TopHeadlinesDTO().apply {
            this.status = status
            this.totalResults = totalResults
            this.articles = articles
        }

        return mockData
    }

    fun getMockSources(): SourcesDTO {
        val status = "ok"
        val totalResults = 1
        val mockSrc = Source("weyay", "Weyay")
        val sources : Array<Source> = arrayOf(mockSrc)

        val mockData = SourcesDTO().apply {
            this.status = status
            this.totalResults = totalResults
            this.sources = sources
        }

        return mockData
    }
}