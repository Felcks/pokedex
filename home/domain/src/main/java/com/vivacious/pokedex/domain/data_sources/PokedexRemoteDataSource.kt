package com.vivacious.pokedex.domain.data_sources

import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface PokedexRemoteDataSource {
    suspend fun getPokemons(limit: Int, offset: Int) : Flow<Resource<List<PokemonSummary>?>>
}