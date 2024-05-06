package com.vivacious.domainimpl.usecases

import androidx.paging.PagingData
import app.cash.turbine.test
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.models.PokemonSummary
import com.vivacious.pokedex.domain.repositories.PokedexRepository
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

class GetPokemonsUseCaseImplTest {

    private lateinit var mockRepository : PokedexRepository
    private lateinit var sut: GetPokemonsUseCaseImpl

    @Before
    fun setup() {
        mockRepository = mockk()
        sut = GetPokemonsUseCaseImpl(mockRepository)
    }

    @Test
    fun `GIVEN repository returns correct WHEN getPokemon THEN returns success`() = runTest {
        val expected = mockk<PagingData<PokemonSummary>>()
        coEvery { mockRepository.getPokemons() } returns flowOf(expected)

        sut.invoke().test {
            coVerify(exactly = 1) { mockRepository.getPokemons() }
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `GIVEN repository throws error WHEN getPokemon THEN returns error`() = runTest {
        val expected = Throwable()
        coEvery { mockRepository.getPokemons() } returns flow {
            throw expected
        }

        sut.invoke().test {
            coVerify(exactly = 1) { mockRepository.getPokemons() }
            assertEquals(expected, awaitError())
        }
    }
}