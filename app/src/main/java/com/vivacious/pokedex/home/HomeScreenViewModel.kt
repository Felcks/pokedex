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

    private val _state = MutableStateFlow(HomeScreenState())
    val state = _state.asStateFlow()

    private var currentPage = 0

    fun handleScreenEvents(event: HomeScreenEvent) {
        when (event) {
            HomeScreenEvent.GetFreshPokemons -> {
                currentPage = 0
                loadPokemons()

            }
            HomeScreenEvent.LoadMorePokemons -> {
                currentPage += 1
                loadPokemons()
            }
        }
    }

    private fun loadPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = _state.value.copy(loading = true, errorMessage = null)
            val resource = getPokemonsUseCase.invoke(currentPage)
            resource.collectLatest { result ->
                result.onSuccess {
                    _state.value = _state.value.copy(pokemons = it ?: listOf(), loading = false, errorMessage = null)
                }
                result.onFailure {
                    _state.value = _state.value.copy(errorMessage = it, loading = false)
                }
            }
        }
    }

}