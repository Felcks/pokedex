package com.vivacious.pokedex.domain.usecases

import com.vivacious.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    suspend fun invoke() : Flow<List<Pokemon>>
}