package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class NewsController(private val newsService: NewsService) {

    @GetMapping("/top-headlines/{country}")
    fun getTopHeadlines(@PathVariable country: String): ResponseEntity<TopHeadlinesDTO> {
        val res = newsService.fetchTopHeadlines(country)

        return ResponseEntity( TopHeadlinesDTO(),
            HttpStatus.ACCEPTED)
    }

    @GetMapping("/source")
    fun fetchSource(): ResponseEntity<SourcesDTO> {

        return ResponseEntity(
            SourcesDTO(),
            HttpStatus.ACCEPTED)
    }

//    @GetMapping("/file-download/{fileUrl}")
//    fun downloadFile(@PathVariable fileUrl: String): ResponseEntity<Resource> {
//
//        return ResponseEntity.ok()
//            .body()
//    }
}
