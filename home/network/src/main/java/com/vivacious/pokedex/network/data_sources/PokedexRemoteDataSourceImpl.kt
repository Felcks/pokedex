package com.vivacious.pokedex.network.data_sources

import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import com.vivacious.pokedex.network.api.PokedexService
import com.vivacious.pokedex.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexRemoteDataSourceImpl @Inject constructor(private val pokedexService: PokedexService) : PokedexRemoteDataSource {
    override suspend fun getPokemons(limit: Int, offset: Int): Flow<Resource<List<PokemonSummary>?>> {
        return safeApiCall(Dispatchers.IO) {
             pokedexService.getPokemons(limit, offset).body()?.results
        }
    }
}