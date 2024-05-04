package com.vivacious.pokedex.domain.usecases

import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonsUseCaseImpl @Inject constructor(private val pokedexRepository: PokedexRepository) : GetPokemonsUseCase {
    override suspend fun invoke(page: Int): Flow<Resource<List<PokemonSummary>?>> {
        return pokedexRepository.getPokemons(page)
    }
}