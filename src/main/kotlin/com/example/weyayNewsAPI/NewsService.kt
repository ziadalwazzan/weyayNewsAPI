package com.example.weyayNewsAPI

import org.springframework.stereotype.Service

@Service
class NewsService {

    fun fetchTopHeadlines(country: String): String {
        // GET request from newsapi.org
        return "resp"
    }

}
