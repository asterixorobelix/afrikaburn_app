package asterixorobelix.afrikaburn.viewmodel

import androidx.lifecycle.ViewModel
import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository
import io.ktor.client.statement.HttpResponse

class CampViewModel(
    private val afrikaburnRepository: AfrikaburnRepository,
    private val greeting: Greeting
) : ViewModel() {

    suspend fun getCamps(): HttpResponse? {
        return try {
            afrikaburnRepository.retrieveAfrikaburnInfo()
        } catch (exception: Exception) {
            null
        }
    }

    fun getHelloWorldGreeting() = greeting.greet()
}