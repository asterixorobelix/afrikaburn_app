package asterixorobelix.afrikaburn


import afrikaburn.composeapp.generated.resources.Res
import afrikaburn.composeapp.generated.resources.compose_multiplatform
import afrikaburn.composeapp.generated.resources.discover
import afrikaburn.composeapp.generated.resources.discover_outline
import afrikaburn.composeapp.generated.resources.map
import afrikaburn.composeapp.generated.resources.map_outline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import asterixorobelix.afrikaburn.camp.CampViewModel
import asterixorobelix.afrikaburn.camp.campsList
import asterixorobelix.afrikaburn.map.mapScreen
import asterixorobelix.afrikaburn.models.ThemeCamp
import asterixorobelix.afrikaburn.navigation.AfrikaburnNavRoutes
import asterixorobelix.afrikaburn.navigation.NavigationItem
import asterixorobelix.afrikaburn.ui.AppTheme
import asterixorobelix.afrikaburn.ui.elements.bottomNavigationBar
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {

    val navController = rememberNavController()

    AppTheme {
        KoinContext {
            Scaffold(bottomBar = {
                bottomNavigationBar(
                    listOf(
                        NavigationItem(
                            AfrikaburnNavRoutes.Discover,
                            selectedIconID = Res.drawable.discover,
                            Res.drawable.discover_outline
                        ),
                        NavigationItem(
                            AfrikaburnNavRoutes.Map,
                            selectedIconID = Res.drawable.map,
                            unselectedIconID = Res.drawable.map_outline
                        )
                    ), navController
                )
            }) {
                NavHost(
                    navController = navController,
                    startDestination = AfrikaburnNavRoutes.Discover.name,
                    modifier = Modifier
                ) {
                    composable(route = AfrikaburnNavRoutes.Discover.name) {
                        campsList()
                    }
                    composable(route = AfrikaburnNavRoutes.Map.name) {
                        mapScreen()
                    }
                }
            }
        }
    }
}