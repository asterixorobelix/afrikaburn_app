package asterixorobelix.afrikaburn.repository

import asterixorobelix.afrikaburn.network.NetworkClient

class AfrikaburnRepository(private val networkClient: NetworkClient) {

    suspend fun retrieveAfrikaburnInfo() = networkClient.getAfrikaburnInfo()
}