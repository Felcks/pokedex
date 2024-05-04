package com.vivacious.pokedex.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.vivacious.pokedex.TopBar
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.ui.theme.PokedexTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val state by homeScreenViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = { TopBar(title = "Pokedex", modifier = Modifier.padding(top = 56.dp, start = 32.dp)) },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            PokemonList(pokemons = state.pokemons)
        }
    }
}


@Composable
fun PokemonList(pokemons: List<PokemonSummary>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        items(pokemons) {
            PokemonCard(pokemonSummary = it, Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
        }
    }
}

@Preview
@Composable
private fun PokemonListPreview() {
    MaterialTheme {
        PokemonList(pokemons = MOCK_POKEDEX)
    }
}

@Composable
fun PokemonCard(pokemonSummary: PokemonSummary, modifier: Modifier = Modifier) {
    Card(modifier = modifier.background(Color.White)) {
        Column {
            SubcomposeAsyncImage(
                model = pokemonSummary.image,
                contentDescription = pokemonSummary.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(CircleShape.copy(all = CornerSize(16.dp)))
            )
            Text(pokemonSummary.name.capitalize(Locale.current), fontSize = 22.sp, modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}

@Preview
@Composable
private fun PokemonCardPreview() {
    PokedexTheme {
        PokemonCard(MOCK_POKEDEX.first())
    }
}

val MOCK_POKEDEX = listOf<PokemonSummary>(
    object : PokemonSummary {
        override val name: String
            get() = "bulbasaur"
        override val url: String
            get() = "https://pokeapi.co/api/v2/pokemon/1/"
        override val image: String
            get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
    },
    object : PokemonSummary {
        override val name: String
            get() = "charmander"
        override val url: String
            get() = "https://pokeapi.co/api/v2/pokemon/4/"
        override val image: String
            get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"
    }
)