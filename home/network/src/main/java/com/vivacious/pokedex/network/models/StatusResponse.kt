package com.vivacious.pokedex.network.models

import com.google.gson.annotations.SerializedName
import com.vivacious.pokedex.domain.models.Status

data class StatusResponse(
    @SerializedName("base_stat")
    override val baseStat: Int,
    override val stat: StatResponse
) : Status