package com.vivacious.pokedex.pokemondetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivacious.pokedex.domain.usecases.GetPokemonUseCase
import com.vivacious.pokedex.domain.wrapper.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var pokemonId: String? = null

    init {
        pokemonId = savedStateHandle["pokemonId"]
    }

    fun handleViewEvents(pokemonDetailEvent: PokemonDetailEvent) {
        when(pokemonDetailEvent) {
            PokemonDetailEvent.LoadPokemon -> loadPokemon()
        }
    }

    private fun loadPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonId?.let {
                getPokemonUseCase.invoke(it).collectLatest {
                    it.onSuccess {
                        Log.i("script2", it?.name ?: "aaa")
                    }

                }
            }
        }
    }
}