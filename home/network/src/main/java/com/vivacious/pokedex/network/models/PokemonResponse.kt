package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName
import com.vivacious.pokedex.domain.models.Pokemon

class PokemonResponse(
    override val id: Int,
    override val name: String,
    override val weight: Int,
    override val height: Int,
    override val abilities: List<AbilityResponse>,
    override val types: List<TypeSlotResponse>,
    @SerializedName("stats")
    override val status: List<StatusResponse>,
    val sprites: SpriteResponse,
) : Pokemon {
    override val image: String
        get() = sprites.other.dreamWorld.frontDetault
}