package asterixorobelix.afrikaburn.navigation

import org.jetbrains.compose.resources.DrawableResource

data class NavigationItem(
    val navRoute: AfrikaburnNavRoutes,
    val selectedIconID: DrawableResource,
    val unselectedIconID: DrawableResource
)
