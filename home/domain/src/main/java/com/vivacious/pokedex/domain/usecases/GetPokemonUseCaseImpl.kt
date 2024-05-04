package com.vivacious.pokedex.domain.usecases

import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.wrapper.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonUseCaseImpl @Inject constructor(
    private val repositoryImpl: PokedexRepository
) : GetPokemonUseCase {
    override suspend fun invoke(pokemonId: String): Flow<Resource<Pokemon?>> {
        return repositoryImpl.getPokemon(pokemonId)
    }

}