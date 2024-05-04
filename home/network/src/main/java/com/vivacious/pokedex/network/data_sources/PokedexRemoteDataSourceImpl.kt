package com.vivacious.pokedex.network.data_sources

import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

class PokedexRemoteDataSourceImpl : PokedexRemoteDataSource {
    override suspend fun getPokemons(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }
}