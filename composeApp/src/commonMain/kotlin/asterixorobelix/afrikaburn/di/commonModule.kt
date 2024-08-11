package asterixorobelix.afrikaburn.di

import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.network.NetworkClient
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.logging.Logger
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val commonModule = module {
    single {
        HttpClient(CIO) {
            install(Logging) {
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                })
            }
        }
    }
    single { NetworkClient(get<HttpClient>()) }
    single { AfrikaburnRepository(get<NetworkClient>()) }
    single { Greeting() }
}