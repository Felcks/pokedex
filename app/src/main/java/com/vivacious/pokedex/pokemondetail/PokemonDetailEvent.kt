package com.vivacious.pokedex.pokemondetail

sealed class PokemonDetailEvent {
    object LoadPokemon : PokemonDetailEvent()
}