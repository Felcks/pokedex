package com.vivacious.domainimpl.di

import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.usecases.GetPokemonUseCase
import com.vivacious.pokedex.domain.usecases.GetPokemonsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetPokemonsUseCase(
        repository: PokedexRepository,
    ): GetPokemonsUseCase {
        return com.vivacious.domainimpl.usecases.GetPokemonsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(
        repository: PokedexRepository,
    ): GetPokemonUseCase {
        return com.vivacious.domainimpl.usecases.GetPokemonUseCaseImpl(repository)
    }
}