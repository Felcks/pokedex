package com.vivacious.pokedex.network.data_sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.network.api.PokedexService

class PokedexPagingSource(val pokedexService: PokedexService, val pageSize: Int) : PagingSource<Int, PokemonSummary>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonSummary> {
        return try {
            val page = params.key ?: 1
            val response = pokedexService.getPokemons(
                limit = pageSize,
                offset = (page - 1) * pageSize,
            ).body()?.results.orEmpty()

            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, PokemonSummary>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}
