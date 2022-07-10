package io.github.viniciusalvesmello.brasilapibanks.client

import io.ktor.client.request.*
import io.ktor.client.statement.*

interface Client {
    suspend fun get(path: String, block: HttpRequestBuilder.() -> Unit = {}) : HttpResponse
}