package com.vivacious.pokedex.pokemondetail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope

@Composable
fun PokemonDetailScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->

        LaunchedEffect(key1 = "") {
            viewModel.handleViewEvents(PokemonDetailEvent.LoadPokemon)
        }

        Text("Pokemon Detail", Modifier.padding(innerPadding))
    }
}