package com.vivacious.pokedex.domain.usecases

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface GetPokemonsUseCase {
    suspend fun invoke(page: Int) : Flow<PagingData<PokemonSummary>>
}