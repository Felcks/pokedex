package com.vivacious.pokedex.presentation.home

sealed class HomeScreenEvent {
    data object GetFreshPokemons : HomeScreenEvent()
    data object LoadMorePokemons : HomeScreenEvent()
}