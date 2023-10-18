package com.example.weyayNewsAPI.dto

import com.example.weyayNewsAPI.models.Article

class TopHeadlinesDTO {
    var status: String? = null

    var totalResults: Int? = null

    var articles: Array<Article>? = null

}