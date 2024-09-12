package asterixorobelix.afrikaburn.di

import io.ktor.client.HttpClient
import org.koin.dsl.module

val commonModule = module {
    single { NetworkClient(HttpClient()) }
}