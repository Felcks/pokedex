package com.vivacious.pokedex.network.models

import com.vivacious.pokedex.domain.models.Ability

data class AbilityResponse(
    override val name: String,
    override val url: String
) : Ability