package com.example.weyayNewsAPI.dto

import com.example.weyayNewsAPI.models.Article
import com.fasterxml.jackson.annotation.JsonProperty

class TopHeadlinesDTO {
    var status: String? = null

    val totalResults: String? = null

    val articles: Array<Article>? = null

}