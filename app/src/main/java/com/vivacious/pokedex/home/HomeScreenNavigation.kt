package com.vivacious.pokedex.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HomeScreenNavigationRoute = "home_screen_navigation"

fun NavController.navigateToHomeScreen(
    navOptions: NavOptions? = null
) {
    this.navigate(HomeScreenNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    goToPokemonDetail: (pokemonUrl: String) -> Unit
) {
    composable(
        HomeScreenNavigationRoute
    ) {
        HomeScreen(
            goToPokemonDetail = goToPokemonDetail
        )
    }
}