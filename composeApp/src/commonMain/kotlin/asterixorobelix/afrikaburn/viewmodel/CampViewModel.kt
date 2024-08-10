package asterixorobelix.afrikaburn.viewmodel

import androidx.lifecycle.ViewModel
import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository

class CampViewModel(
    private val afrikaburnRepository: AfrikaburnRepository,
    private val greeting: Greeting
) : ViewModel() {

    suspend fun getCamps() = afrikaburnRepository.retrieveAfrikaburnInfo()

    fun getHelloWorldGreeting() = greeting.greet()
}