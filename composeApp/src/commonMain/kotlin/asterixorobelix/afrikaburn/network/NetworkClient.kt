package asterixorobelix.afrikaburn.network

import asterixorobelix.afrikaburn.models.AfrikaburnData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class NetworkClient(private val ktorClient: HttpClient) {

    suspend fun getAfrikaburnInfo(): AfrikaburnData? {
        return try {
            ktorClient.get("https://www.jsonkeeper.com/b/99ON").body<AfrikaburnData>()
        } catch (exception: Exception) {
            null
        }
    }
}