package com.example.weyayNewsAPI

import com.example.weyayNewsAPI.dto.SourcesDTO
import com.example.weyayNewsAPI.dto.TopHeadlinesDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*


@RestController
class NewsController(private val newsService: NewsService) {
    private final var LOGGER: Logger = LoggerFactory.getLogger(NewsController::class.java)

    @GetMapping("/top-headlines/{country}")
    fun getTopHeadlines(@PathVariable country: String): TopHeadlinesDTO {
        LOGGER.info("Inside of NewsController.getTopHeadlines() with country=$country")
        return newsService.fetchTopHeadlines(country)
    }

    @GetMapping("/sources")
    fun getSource(): SourcesDTO {
        LOGGER.info("Inside of NewsController.getSource()")
        return newsService.fetchSources()
    }

    @GetMapping("/file-download")
    fun downloadFile(@RequestParam fileUrl: String): ByteArray {
        LOGGER.info("Inside of NewsController.downloadFile()")
        return newsService.downloadFile(fileUrl)
    }
}
