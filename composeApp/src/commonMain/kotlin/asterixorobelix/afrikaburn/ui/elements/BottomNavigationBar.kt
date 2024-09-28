package asterixorobelix.afrikaburn.ui.elements

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import asterixorobelix.afrikaburn.navigation.AfrikaburnNavRoutes
import asterixorobelix.afrikaburn.navigation.NavigationItem
import org.jetbrains.compose.resources.vectorResource

@Composable
fun bottomNavigationBar(navItems: List<NavigationItem>, navController: NavController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = vectorResource(
                            resource = if (selectedItem == index) item.selectedIconID
                            else item.unselectedIconID
                        ),
                        contentDescription = item.navRoute.name
                    )
                },
                label = { Text(item.navRoute.name) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navigateBottomBar(navController, item.navRoute)
                }
            )
        }
    }
}

private fun navigateBottomBar(
    navController: NavController,
    afrikaburnNavRoutes: AfrikaburnNavRoutes
) {
    navController.navigate(afrikaburnNavRoutes.name) {
        navController.graph.startDestinationRoute?.let {
            popUpTo(AfrikaburnNavRoutes.Discover.name) {
                saveState = true
            }
        }
        launchSingleTop = true
        restoreState = true
    }
}