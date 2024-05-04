package com.vivacious.pokedex.home

sealed class HomeScreenEvent {
    data object GetFreshPokemons : HomeScreenEvent()
    data object LoadMorePokemons : HomeScreenEvent()
}