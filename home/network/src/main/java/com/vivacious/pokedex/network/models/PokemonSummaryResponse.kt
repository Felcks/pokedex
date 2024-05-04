package com.vivacious.pokedex.network.models

import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.network.Constants.POKEMON_IMAGE_BASE_URL

data class PokemonSummaryResponse(
    override val name: String,
    override val url: String
) : PokemonSummary {
    override val image: String
        get() = POKEMON_IMAGE_BASE_URL + url.substring(0, url.length-1).split("/").last() + ".png"
}