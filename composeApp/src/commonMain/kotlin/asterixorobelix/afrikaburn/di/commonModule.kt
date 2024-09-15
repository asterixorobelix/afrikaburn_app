package asterixorobelix.afrikaburn.di

import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.graphql.MondayAuthorizationInterceptor
import asterixorobelix.afrikaburn.network.NetworkClient
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository
import com.apollographql.apollo.ApolloClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val commonModule = module {
    single {
        HttpClient {
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
    single { AfrikaburnRepository(get<NetworkClient>(), get<ApolloClient>()) }
    single { Greeting() }

    single {
        ApolloClient.Builder()
            .serverUrl("https://api.monday.com/v2")
            .addHttpInterceptor(
                MondayAuthorizationInterceptor(
                    "api token here",
                    apiVersion = "2024-07"
                )
            )
            .build()
    }
}