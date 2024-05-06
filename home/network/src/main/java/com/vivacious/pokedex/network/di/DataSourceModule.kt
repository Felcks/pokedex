package com.vivacious.pokedex.network.di

import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.network.api.PokedexService
import com.vivacious.pokedex.network.data_sources.PokedexRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providePokedexRemoteDataSource(
        pokedexService: PokedexService,
    ): PokedexRemoteDataSource {
        return PokedexRemoteDataSourceImpl(pokedexService = pokedexService)
    }
}