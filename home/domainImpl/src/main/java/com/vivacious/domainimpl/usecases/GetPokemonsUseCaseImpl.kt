package com.vivacious.domainimpl.usecases

import androidx.paging.PagingData
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.usecases.GetPokemonsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsUseCaseImpl @Inject constructor(private val pokedexRepository: PokedexRepository) :
    GetPokemonsUseCase {
    override suspend fun invoke(page: Int): Flow<PagingData<PokemonSummary>> {
        return pokedexRepository.getPokemons(page)
    }
}