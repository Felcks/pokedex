package com.vivacious.pokedex.home

import com.vivacious.pokedex.domain.models.PokemonSummary

data class HomeScreenState(
    val loading: Boolean = false,
    val pokemons: List<PokemonSummary> = listOf()
)