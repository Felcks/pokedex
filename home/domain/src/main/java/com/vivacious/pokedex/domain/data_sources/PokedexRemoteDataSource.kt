package com.vivacious.pokedex.domain.data_sources

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface PokedexRemoteDataSource {
    suspend fun getPokemons(pageSize: Int) : Flow<PagingData<PokemonSummary>>
}