package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName
import com.vivacious.pokedex.domain.models.Type

data class TypeSlotResponse(
    override val slot: Int,
    @SerializedName("type")
    val typeResponse: TypeResponse,
) : Type {
    override val name: String
        get() = typeResponse.name
    override val url: String
        get() = typeResponse.url

}