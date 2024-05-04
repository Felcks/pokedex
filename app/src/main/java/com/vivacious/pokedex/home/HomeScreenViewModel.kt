package com.vivacious.pokedex.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivacious.pokedex.domain.usecases.GetPokemonsUseCase
import com.vivacious.pokedex.domain.wrapper.onFailure
import com.vivacious.pokedex.domain.wrapper.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeScreenState(pokemons = MOCK_POKEDEX))
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getPokemonsUseCase.invoke(0)
            result.collectLatest { it ->
                it.onSuccess {
                    _state.value = _state.value.copy(pokemons = it ?: listOf())
                }
                it.onFailure {
                    Log.i("script2", "aaaa")
                }
            }
        }
    }

}