package com.vivacious.pokedex.domain.usecases

import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface GetPokemonUseCase {
    suspend operator fun invoke(pokemonId: String): Flow<Resource<Pokemon?>>
}