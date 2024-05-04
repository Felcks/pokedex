package com.vivacious.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vivacious.pokedex.home.HomeScreenNavigationRoute
import com.vivacious.pokedex.home.homeScreen
import com.vivacious.pokedex.home.navigateToHomeScreen

@Composable
fun PokedexNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenNavigationRoute, modifier = modifier) {
        homeScreen(goToPokemonDetail = {
            navController.navigateToHomeScreen()
        })
    }
}