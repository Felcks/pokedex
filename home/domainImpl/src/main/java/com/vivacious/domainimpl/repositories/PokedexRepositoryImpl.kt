package com.vivacious.domainimpl.repositories

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(private val pokedexRemoteDataSource: PokedexRemoteDataSource) :
    PokedexRepository {

    override suspend fun getPokemons(page: Int): Flow<PagingData<PokemonSummary>> {
        return pokedexRemoteDataSource.getPokemons(PAGE_SIZE)
    }

    override suspend fun getPokemon(pokemonId: String): Flow<Resource<Pokemon?>> {
        return pokedexRemoteDataSource.getPokemon(pokemonId)
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}