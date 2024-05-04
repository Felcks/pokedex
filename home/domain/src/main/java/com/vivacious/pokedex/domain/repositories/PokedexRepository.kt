package com.vivacious.pokedex.domain.repositories

import com.vivacious.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun getPokemons(page: Int = 1): Flow<List<Pokemon>>
}