package com.github.kmachida12345.otenki_kmm

import io.ktor.client.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.delay

class MyHttpClient {
    val httpClient: HttpClient = HttpClient {
        expectSuccess = false
        ResponseObserver { response ->
            println("hoge HTTP status: ${response.status.value}")
        }
    }

    suspend fun get() {

        val htmlContent = httpClient.request<String> {
            url("https://www.google.com/")
            method = HttpMethod.Get
        }
        println("hoge=$htmlContent")
        httpClient.close()
    }

}