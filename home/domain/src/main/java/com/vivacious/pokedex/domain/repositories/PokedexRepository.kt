package com.vivacious.pokedex.domain.repositories

import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    suspend fun getPokemons(page: Int = 1): Flow<Resource<List<PokemonSummary>?>>
}