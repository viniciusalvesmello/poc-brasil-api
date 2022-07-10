package io.github.viniciusalvesmello.brasilapibanks.client

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

class ClientImpl : Client {

    private val client: HttpClient by lazy {
        HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }

    override suspend fun get(path: String, block: HttpRequestBuilder.() -> Unit): HttpResponse =
        client.get("$URL$path", block)/* {
            headers {
                append(HttpHeaders.ContentType, "application/json")
                append(HttpHeaders.Accept, "application/json")
            }
            url {
                protocol = URLProtocol.HTTPS
                host = URL
                path(path)
            }
        }*/

    private companion object {
        const val URL: String = "https://brasilapi.com.br/api"
    }
}