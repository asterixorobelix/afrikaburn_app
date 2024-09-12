package asterixorobelix.afrikaburn.artwork

import asterixorobelix.afrikaburn.network.NetworkClient

class ArtworkRepository(private val networkClient: NetworkClient) {
    suspend fun retrieveThemeCamps() = networkClient.getAfrikaburnInfo()?.artwork
}