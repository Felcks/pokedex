package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName

data class OfficialArtworkResponse(
    @SerializedName("front_default")
    val frontDefault: String
)