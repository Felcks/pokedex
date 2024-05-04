package com.vivacious.pokedex.network.models

data class PageModel<T>(
    val count: Int,
    val results: List<T>,
)