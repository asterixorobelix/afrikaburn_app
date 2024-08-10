package asterixorobelix.afrikaburn.di

import asterixorobelix.afrikaburn.network.NetworkClient
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val commonModule = module {
    single { NetworkClient(HttpClient()) }
    single { AfrikaburnRepository(get<NetworkClient>()) }
}