package com.example.weyayNewsAPI.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Source(
    val id: String?=null,
    val name: String?=null,
    val description: String?=null,
    val url: String?=null,
    val category: String?=null,
    val language: String?=null,
    val country: String?=null)