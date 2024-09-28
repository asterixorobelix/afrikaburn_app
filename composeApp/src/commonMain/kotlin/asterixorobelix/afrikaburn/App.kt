package asterixorobelix.afrikaburn


import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import asterixorobelix.afrikaburn.camp.CampViewModel
import asterixorobelix.afrikaburn.camp.campsList
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.navigation.AfrikaburnNavRoutes
import asterixorobelix.afrikaburn.ui.AppTheme
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    AppTheme {
        KoinContext {
            campsList()
        }
    }
}