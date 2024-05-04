package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName

data class OtherSpriteResponse (
    @SerializedName("dream_world")
    val dreamWorld: DreamWorldSpriteResponse
)