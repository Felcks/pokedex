package com.vivacious.pokedex.presentation.pokemondetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

const val PokemonDetailNavigationRoute = "pokemon_detail_navigation_route"

fun NavController.navigateToPokemonDetail(
    pokemonUrl: String,
    navOptions: NavOptions? = null
) {
    val pokemonId = pokemonUrl.substring(0, pokemonUrl.length - 1).split("/").last()
    this.navigate("$PokemonDetailNavigationRoute/$pokemonId", navOptions)
}

fun NavGraphBuilder.pokemonDetail(
    onBackClick: () -> Unit
) {
    composable(
        "$PokemonDetailNavigationRoute/{pokemonId}",
        arguments = listOf(
            navArgument("pokemonId") {
                defaultValue = ""
                type = NavType.StringType
                nullable = true
            }
        )
    ) {
        PokemonDetailScreen(
            onBackClick
        )
    }
}