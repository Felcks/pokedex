package com.vivacious.pokedex.network.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PokedexRetrofit

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PokedexOkHttpClient

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class InterceptorLogging