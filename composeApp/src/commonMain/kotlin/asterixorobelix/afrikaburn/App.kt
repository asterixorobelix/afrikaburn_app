package asterixorobelix.afrikaburn

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import org.jetbrains.compose.ui.tooling.preview.Preview

import asterixorobelix.afrikaburn.camp.CampViewModel
import asterixorobelix.afrikaburn.camp.campsList
import asterixorobelix.afrikaburn.ui.AppTheme
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    AppTheme {
        KoinContext {
            val viewModel = koinViewModel<CampViewModel>()
            val coroutineScope = rememberCoroutineScope()
            campsList(viewModel.themeCamps, viewModel.isLoading)
        }
    }
}