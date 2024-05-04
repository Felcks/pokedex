package com.vivacious.pokedex.domain.data_sources

import com.vivacious.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRemoteDataSource {
    suspend fun getPokemons() : Flow<List<Pokemon>>
}