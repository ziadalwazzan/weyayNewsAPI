package com.example.weyayNewsAPI.dto

import com.example.weyayNewsAPI.models.Source
import com.fasterxml.jackson.annotation.JsonProperty


class SourcesDTO {
    var status: String? = null

    var totalResults: Int? = null

    val sources: Array<Source>? = null

}