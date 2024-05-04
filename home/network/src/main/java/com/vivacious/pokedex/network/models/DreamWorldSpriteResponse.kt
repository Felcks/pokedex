package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName

data class DreamWorldSpriteResponse(
    @SerializedName("front_default")
    val frontDetault: String
)