package com.vivacious.pokedex.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.usecases.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
) : ViewModel() {

    private val _pokemons: MutableStateFlow<PagingData<PokemonSummary>> = MutableStateFlow(PagingData.empty())
    val pokemons = _pokemons.asStateFlow()

    private var currentPage by mutableIntStateOf(0)

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
            getPokemonsUseCase.invoke(currentPage).cachedIn(viewModelScope).collect {
                _pokemons.value = it
            }
        }
    }

}