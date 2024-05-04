package com.vivacious.pokedex.domain.repositories

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    suspend fun getPokemons(page: Int = 1): Flow<PagingData<PokemonSummary>>
    suspend fun getPokemon(pokemonId: String): Flow<Resource<Pokemon?>>
}