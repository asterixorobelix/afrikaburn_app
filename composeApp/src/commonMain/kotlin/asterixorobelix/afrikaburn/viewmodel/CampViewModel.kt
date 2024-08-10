package asterixorobelix.afrikaburn.viewmodel

import androidx.lifecycle.ViewModel
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository

class CampViewModel(private val afrikaburnRepository: AfrikaburnRepository) : ViewModel() {

    suspend fun getCamps() = afrikaburnRepository.retrieveAfrikaburnInfo()
}