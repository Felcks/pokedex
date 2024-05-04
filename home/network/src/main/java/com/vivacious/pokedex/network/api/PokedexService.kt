package com.vivacious.pokedex.network.api

import com.vivacious.pokedex.network.models.PageModel
import com.vivacious.pokedex.network.models.PokemonSummaryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokedexService {

    @GET("pokemon")
    suspend fun getPokemons(
        @Query(value = "limit") limit: Int,
        @Query(value = "offset") offset: Int
    ): Response<PageModel<PokemonSummaryResponse>>
}