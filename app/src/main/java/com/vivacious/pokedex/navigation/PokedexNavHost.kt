package com.vivacious.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vivacious.pokedex.presentation.home.HomeScreenNavigationRoute
import com.vivacious.pokedex.presentation.home.homeScreen
import com.vivacious.pokedex.presentation.pokemondetail.navigateToPokemonDetail
import com.vivacious.pokedex.presentation.pokemondetail.pokemonDetail

@Composable
fun PokedexNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenNavigationRoute, modifier = modifier) {
        homeScreen(goToPokemonDetail = {
            navController.navigateToPokemonDetail(pokemonUrl = it)
        })
        pokemonDetail(onBackClick = { navController.popBackStack() })
    }
}