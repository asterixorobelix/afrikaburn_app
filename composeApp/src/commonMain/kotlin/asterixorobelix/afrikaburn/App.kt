package asterixorobelix.afrikaburn


import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import asterixorobelix.afrikaburn.camp.CampViewModel
import asterixorobelix.afrikaburn.camp.campsList
import asterixorobelix.afrikaburn.models.ThemeCamp
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            var showContent by remember { mutableStateOf(false) }
            val viewModel = koinViewModel<CampViewModel>()
            val coroutineScope = rememberCoroutineScope()
            val data = remember { mutableStateOf(listOf<ThemeCamp>()) }
            coroutineScope.launch {
                data.value = viewModel.getCamps()
            }
            campsList(data.value)
        }
    }

}