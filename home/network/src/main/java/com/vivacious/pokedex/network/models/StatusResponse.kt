package com.vivacious.pokedex.network.models

import com.vivacious.pokedex.domain.models.Stat
import com.vivacious.pokedex.domain.models.Status

data class StatusResponse(
    override val baseStat: Int,
    override val stat: StatResponse
) : Status