package asterixorobelix.afrikaburn.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class NetworkClient(private val ktorClient: HttpClient) {

    suspend fun getAfrikaburnInfo(): HttpResponse {
        return ktorClient.get("https://www.jsonkeeper.com/b/99ON")
    }
}