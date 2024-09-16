package asterixorobelix.afrikaburn.camp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import asterixorobelix.afrikaburn.Greeting
import asterixorobelix.afrikaburn.models.CIDisplayElement
import asterixorobelix.afrikaburn.models.CreativeInitiativeDisplayElement
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.repository.AfrikaburnRepository
import kotlinx.coroutines.launch

class CampViewModel(
    private val afrikaburnRepository: AfrikaburnRepository
) : ViewModel() {
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val ci = mutableStateOf(listOf<CreativeInitiativeDisplayElement>())
    val creativeInitiatives: State<List<CreativeInitiativeDisplayElement>> = ci

    init {
        this.viewModelScope.launch {
            getCI()
        }
    }

    private suspend fun getCI() {
        _isLoading.value = true
        ci.value = afrikaburnRepository.retrieveAfrikaburnInfo() ?: listOf()
        _isLoading.value = false
    }
}