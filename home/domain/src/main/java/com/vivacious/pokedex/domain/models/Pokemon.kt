package com.vivacious.pokedex.domain.models

interface Pokemon {
    val id: Int
    val name: String
    val width: Int
    val height: Int
    val image: String
    val abilities: List<Ability>
    val types: List<Type>
    val status: List<Status>
}