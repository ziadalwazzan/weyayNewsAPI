package com.example.weyayNewsAPI.dto

import com.example.weyayNewsAPI.models.Source
import com.fasterxml.jackson.annotation.JsonProperty


class SourcesDTO {
    @JsonProperty("status")
    var status: String? = null

    @JsonProperty("totalResults")
    val totalResults: String? = null

    @JsonProperty("articles")
    val sources: Array<Source>? = null

}