package com.example.domain

import com.example.domain.base.BaseUnitTest
import com.example.domain.entities.MovieModel
import com.example.domain.repository.MovieRepository
import com.example.domain.usecase.GetMovieDetailUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import javax.inject.Inject
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetMovieDetailUseCaseTest : BaseUnitTest() {

    @Inject
    lateinit var getMovieDetailUseCase: GetMovieDetailUseCase

    @Mock
    lateinit var mockRepository: MovieRepository

    @Before
    override fun setup() {
        mockRepository = mockk()
        getMovieDetailUseCase = GetMovieDetailUseCase(mockRepository)
    }

    @Test
    fun `invoke returns success when repository returns data`() {
        val fakeData = MovieModel()
        coEvery { mockRepository.getMovieDetail(1) } returns fakeData
        val useCase = GetMovieDetailUseCase(mockRepository)

        runBlocking {
            useCase(GetMovieDetailUseCase.Input(1))
        }

        coVerify { mockRepository.getMovieDetail(1) }
        confirmVerified(mockRepository)
    }
}
