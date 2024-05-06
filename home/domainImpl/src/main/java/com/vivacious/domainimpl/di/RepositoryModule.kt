package com.vivacious.domainimpl.di

import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePokedexRepositoru(
        service: PokedexRemoteDataSource,
    ): PokedexRepository {
        return com.vivacious.domainimpl.repositories.PokedexRepositoryImpl(service)
    }
}