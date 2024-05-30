package com.sananhaji.presentation_common.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

private const val ROUTE_HOME = "home"
private const val ROUTE_FAVORITES = "favorites"
private const val ROUTE_SETTINGS = "settings"

sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    data object Home : NavRoutes(ROUTE_HOME)
    data object Favorites : NavRoutes(ROUTE_FAVORITES)
    data object Settings : NavRoutes(ROUTE_SETTINGS)

}