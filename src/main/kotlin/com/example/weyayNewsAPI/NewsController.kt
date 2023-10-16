package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class NewsController(private val newsService: NewsService) {

    @GetMapping("/top-headlines/{country}")
    fun getTopHeadlines(@PathVariable country: String): ResponseEntity<TopHeadlinesDTO> {
        return newsService.fetchTopHeadlines(country)
    }

    @GetMapping("/sources")
    fun getSource(): ResponseEntity<SourcesDTO> {
        return newsService.fetchSources()
    }

    @GetMapping("/file-download")
    fun downloadFile(@RequestParam fileUrl: String): ResponseEntity<ByteArray> {
        return newsService.downloadFile(fileUrl)
    }
}
