package com.vivacious.pokedex.domain.repositories

import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(private val pokedexRemoteDataSource: PokedexRemoteDataSource) : PokedexRepository {

    override suspend fun getPokemons(page: Int): Flow<Resource<List<PokemonSummary>?>> {
        return pokedexRemoteDataSource.getPokemons(limit = PAGE_SIZE, offset = page * PAGE_SIZE)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}