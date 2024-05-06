package com.vivacious.pokedex.presentation.pokemondetail

import com.vivacious.pokedex.domain.models.Pokemon

data class PokemonDetailState(
    val loading: Boolean = false,
    val errorMessage : String? = null,
    val pokemon: Pokemon? = null
)