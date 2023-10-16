package com.example.weyayNewsAPI.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Article(
        @JsonProperty("source")
        val source: Source,
        val author: String?,
        val title: String?,
        val description: String?,
        val url: String?,
        val urlToImage: String?,
        val publishedAt: String?,
        val content: String?)