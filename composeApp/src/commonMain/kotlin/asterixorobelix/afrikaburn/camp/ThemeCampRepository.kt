package asterixorobelix.afrikaburn.camp

import asterixorobelix.afrikaburn.network.NetworkClient

class ThemeCampRepository(private val networkClient: NetworkClient) {
    suspend fun retrieveThemeCamps() = networkClient.getAfrikaburnInfo()?.themeCamps
}