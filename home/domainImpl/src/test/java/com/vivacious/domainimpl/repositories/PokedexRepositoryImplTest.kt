package com.vivacious.domainimpl.repositories

import androidx.paging.PagingData
import app.cash.turbine.test
import com.vivacious.pokedex.domain.data_sources.PokedexRemoteDataSource
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.wrapper.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class PokedexRepositoryImplTest {

    private lateinit var mockPokedexRemoteDataSource: PokedexRemoteDataSource
    private lateinit var sut : PokedexRepositoryImpl

    @Before
    fun setup() {
        mockPokedexRemoteDataSource = mockk<PokedexRemoteDataSource>()
        sut = PokedexRepositoryImpl(mockPokedexRemoteDataSource)
    }

    @Test
    fun `GIVEN no parameters WHEN getPokemons() THEN returns correctly` () = runTest {
        val expected = mockk<PagingData<PokemonSummary>>()
        coEvery {  mockPokedexRemoteDataSource.getPokemons(PokedexRepositoryImpl.PAGE_SIZE) } returns flowOf(expected)

        sut.getPokemons().test {
            assertEquals(expected, awaitItem())
            coVerify(exactly = 1) { mockPokedexRemoteDataSource.getPokemons(PokedexRepositoryImpl.PAGE_SIZE) }
            awaitComplete()
        }
    }

    @Test
    fun `GIVEN error on dataSource WHEN getPokemons() THEN throws error` () = runTest {
        val expected = Throwable()
        coEvery {  mockPokedexRemoteDataSource.getPokemons(PokedexRepositoryImpl.PAGE_SIZE) } returns flow {
            throw expected
        }

        sut.getPokemons().test {
            coVerify(exactly = 1) { mockPokedexRemoteDataSource.getPokemons(PokedexRepositoryImpl.PAGE_SIZE) }
            assertEquals(expected, awaitError())
        }
    }

    @Test
    fun `GIVEN pokemonId WHEN getPokemon() THEN returns correctly` () = runTest {
        val expected = mockk<Resource<Pokemon>>()
        val pokemonId = "pokemonId"

        coEvery {  mockPokedexRemoteDataSource.getPokemon(pokemonId) } returns flowOf(expected)

        sut.getPokemon(pokemonId).test {
            assertEquals(expected, awaitItem())
            coVerify(exactly = 1) { mockPokedexRemoteDataSource.getPokemon(pokemonId) }
            awaitComplete()
        }
    }

    @Test
    fun `GIVEN error on dataSource WHEN getPokemon() THEN throws error` () = runTest {
        val expected = Throwable()
        val pokemonId = "pokemonId"
        coEvery {  mockPokedexRemoteDataSource.getPokemon(pokemonId) } returns flow {
            throw expected
        }

        sut.getPokemon(pokemonId).test {
            coVerify(exactly = 1) { mockPokedexRemoteDataSource.getPokemon(pokemonId) }
            assertEquals(expected, awaitError())
        }
    }
}