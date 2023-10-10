package com.example.weyayNewsAPI.dto

import com.example.weyayNewsAPI.models.Article
import com.fasterxml.jackson.annotation.JsonProperty

class TopHeadlinesDTO {
    @JsonProperty("status")
    var status: String? = null

    @JsonProperty("totalArticles")
    val totalArticles: String? = null

    @JsonProperty("articles")
    val articles: Array<Article>? = null

}