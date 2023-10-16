package com.example.weyayNewsAPI.remote

import java.net.http.HttpClient


interface HttpClientInterface {
    fun getClient(): HttpClient
}