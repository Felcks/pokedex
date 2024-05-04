package com.vivacious.pokedex.network.models

import com.vivacious.pokedex.domain.models.Stat

data class StatResponse(override val name: String, override val url: String) : Stat