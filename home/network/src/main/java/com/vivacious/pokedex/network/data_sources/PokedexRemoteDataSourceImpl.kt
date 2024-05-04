package com.vivacious.pokedex.network.data_sources

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import com.vivacious.pokedex.network.api.PokedexService
import com.vivacious.pokedex.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class PokedexRemoteDataSourceImpl @Inject constructor(private val pokedexService: PokedexService) : PokedexRemoteDataSource {

    override suspend fun getPokemons(pageSize: Int): Flow<PagingData<PokemonSummary>> {
        val pagingConfig = PagingConfig(pageSize = pageSize)
        return Pager(
            config = pagingConfig,
            initialKey = 1,
            pagingSourceFactory = { PokedexPagingSource(pokedexService = pokedexService, pageSize = pageSize) }
        ).flow
    }

    override suspend fun getPokemon(pokemonId: String): Flow<Resource<Pokemon?>> {
        return safeApiCall(Dispatchers.IO) {
            pokedexService.getPokemon(pokemonId).body()
        }
    }
}