package com.vivacious.pokedex.domain.repositories

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.PokemonSummary
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(private val pokedexRemoteDataSource: PokedexRemoteDataSource) : PokedexRepository {

    override suspend fun getPokemons(page: Int): Flow<PagingData<PokemonSummary>> {
        return pokedexRemoteDataSource.getPokemons(PAGE_SIZE)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}