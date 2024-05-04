package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName

data class OtherSpriteResponse (
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkResponse
)