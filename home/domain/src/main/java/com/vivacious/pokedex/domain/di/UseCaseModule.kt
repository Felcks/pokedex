package com.vivacious.pokedex.domain.di

import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.repositories.PokedexRepositoryImpl
import com.vivacious.pokedex.domain.usecases.GetPokemonUseCase
import com.vivacious.pokedex.domain.usecases.GetPokemonUseCaseImpl
import com.vivacious.pokedex.domain.usecases.GetPokemonsUseCase
import com.vivacious.pokedex.domain.usecases.GetPokemonsUseCaseImpl
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
        return GetPokemonsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(
        repository: PokedexRepository,
    ): GetPokemonUseCase {
        return GetPokemonUseCaseImpl(repository)
    }
}