package com.vivacious.domainimpl.usecases

import app.cash.turbine.test
import com.vivacious.pokedex.domain.models.Pokemon
import com.vivacious.pokedex.domain.repositories.PokedexRepository
import com.vivacious.pokedex.domain.wrapper.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class GetPokemonUseCaseImplTest  {

    private lateinit var mockRepository : PokedexRepository
    private lateinit var sut: GetPokemonUseCaseImpl

    @Before
    fun setup() {
        mockRepository = mockk()
        sut = GetPokemonUseCaseImpl(mockRepository)
    }

    @Test
    fun `GIVEN repository returns correct WHEN getPokemon THEN returns success`() = runTest {
        val pokemonId = "pokemonId"
        val expected = mockk<Resource<Pokemon>>()
        coEvery { mockRepository.getPokemon(pokemonId) } returns flowOf(expected)

        sut.invoke(pokemonId).test {
            coVerify(exactly = 1) { mockRepository.getPokemon(pokemonId) }
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `GIVEN repository throws error WHEN getPokemon THEN returns error`() = runTest {
        val pokemonId = "pokemonId"
        val expected = Throwable()
        coEvery { mockRepository.getPokemon(pokemonId) } returns flow {
            throw expected
        }

        sut.invoke(pokemonId).test {
            coVerify(exactly = 1) { mockRepository.getPokemon(pokemonId) }
            assertEquals(expected, awaitError())
        }
    }
}