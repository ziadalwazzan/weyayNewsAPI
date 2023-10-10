package com.example.weyayNewsAPI.models

data class Source(val id: Int,
                  val name: String,
                  val description: String,
                  val url: String,
                  val category: String,
                  val language: String,
                  val country: String)