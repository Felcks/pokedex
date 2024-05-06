package com.vivacious.pokedex.network.di

import com.vivacious.pokedex.network.api.PokedexService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providePokedexService(@PokedexRetrofit retrofit: Retrofit): PokedexService =
        retrofit.create(PokedexService::class.java)
}