package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import org.springframework.web.bind.annotation.*


@RestController
class NewsController(private val newsService: NewsService) {

    @GetMapping("/top-headlines/{country}")
    fun getTopHeadlines(@PathVariable country: String): TopHeadlinesDTO {
        return newsService.fetchTopHeadlines(country)
    }

    @GetMapping("/sources")
    fun getSource(): SourcesDTO {
        return newsService.fetchSources()
    }

    @GetMapping("/file-download")
    fun downloadFile(@RequestParam fileUrl: String): ByteArray {
        return newsService.downloadFile(fileUrl)
    }
}
