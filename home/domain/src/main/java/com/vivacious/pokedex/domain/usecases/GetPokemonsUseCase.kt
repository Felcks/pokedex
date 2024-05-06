package com.vivacious.pokedex.domain.usecases

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.models.PokemonSummary
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    suspend fun invoke() : Flow<PagingData<PokemonSummary>>
}