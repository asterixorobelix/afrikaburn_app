package asterixorobelix.afrikaburn.camp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository

class CampViewModel(
    private val afrikaburnRepository: AfrikaburnRepository,
    private val greeting: Greeting
) : ViewModel() {

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    suspend fun getCamps(): List<ThemeCamp> {
        _isLoading.value = true
        val camps = afrikaburnRepository.retrieveAfrikaburnInfo()?.themeCamps ?: listOf()
        _isLoading.value = false
        return camps
    }

    fun getHelloWorldGreeting() = greeting.greet()
}