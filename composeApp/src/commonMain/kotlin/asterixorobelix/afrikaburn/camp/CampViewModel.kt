package asterixorobelix.afrikaburn.camp

import androidx.lifecycle.ViewModel
import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository

class CampViewModel(
    private val afrikaburnRepository: AfrikaburnRepository,
    private val greeting: Greeting
) : ViewModel() {

    suspend fun getCamps(): List<ThemeCamp> {
        return afrikaburnRepository.retrieveAfrikaburnInfo()?.themeCamps ?: listOf()
    }

    fun getHelloWorldGreeting() = greeting.greet()
}