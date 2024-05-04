package com.vivacious.pokedex.domain.repositories

import com.vivacious.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PokedexRepositoryImpl : PokedexRepository {
    override fun getPokemons(page: Int): Flow<List<Pokemon>> {
        //TODO
        return flowOf()
    }
}