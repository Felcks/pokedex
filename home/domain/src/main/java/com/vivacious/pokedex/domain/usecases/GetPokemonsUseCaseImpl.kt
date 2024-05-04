package com.vivacious.pokedex.domain.usecases

import com.vivacious.pokedex.domain.models.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetPokemonsUseCaseImpl : GetPokemonsUseCase {
    override suspend fun invoke(): Flow<List<Pokemon>> {
        //TODO
        return flowOf()
    }
}