package asterixorobelix.afrikaburn.camp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository
import kotlinx.coroutines.launch

class CampViewModel(
    private val afrikaburnRepository: AfrikaburnRepository
) : ViewModel() {
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val camps = mutableStateOf(listOf<ThemeCamp>())
    val themeCamps: State<List<ThemeCamp>> = camps

    init {
        this.viewModelScope.launch {
            getCamps()
        }
    }

    private suspend fun getCamps() {
        _isLoading.value = true
        camps.value = afrikaburnRepository.retrieveAfrikaburnInfo()?.themeCamps ?: listOf()
        _isLoading.value = false
    }
}