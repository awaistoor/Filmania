package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.model.home.MoviesDomainModel
import com.yaasir.filmania.domain.model.home.ResultDomainModel
import com.yaasir.filmania.domain.repository.home.HomeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMoviesListUseCaseTest {

    private lateinit var SUT: GetMoviesListUseCase

    @Mock
    private lateinit var homeRepository: HomeRepository

    @Mock
    private lateinit var formatDateToYearUseCase: FormatDateToYearUseCase

    @Mock
    private lateinit var convertVoteToRatingUseCase: ConvertVoteToRatingUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = GetMoviesListUseCase(
            homeRepository = homeRepository,
            formatDateToYearUseCase = formatDateToYearUseCase,
            convertVoteToRatingUseCase = convertVoteToRatingUseCase
        )
    }

    @Test
    fun testInvoke() = runBlocking {
        val model = getDummyMoviesModel()
        Mockito.`when`(homeRepository.getTrendingMovies()).thenReturn(model)
        Mockito.`when`(formatDateToYearUseCase(getDummyDate())).thenReturn(getDummyFormattedDate())
        Mockito.`when`(convertVoteToRatingUseCase(0.0)).thenReturn(0.0)
        Assert.assertEquals(SUT.invoke(), model)
    }

    @Test
    fun `when invoke, verify homeRepository,formatDateToYearUseCase and convertVoteToRatingUseCase are invoked`(): Unit =
        runBlocking {
            val model = getDummyMoviesModel()
            Mockito.`when`(homeRepository.getTrendingMovies()).thenReturn(model)
            Mockito.`when`(formatDateToYearUseCase(getDummyDate()))
                .thenReturn(getDummyFormattedDate())
            Mockito.`when`(convertVoteToRatingUseCase(0.0)).thenReturn(0.0)
            SUT.invoke()
            Mockito.verify(homeRepository).getTrendingMovies()
            Mockito.verify(formatDateToYearUseCase).invoke(getDummyDate())
            Mockito.verify(convertVoteToRatingUseCase).invoke(0.0)
        }

    private fun getDummyFormattedDate(): String = "March 20, 2023"

    private fun getDummyDate(): String = "2023-03-07"

    private fun getDummyMoviesModel(): MoviesDomainModel {
        return MoviesDomainModel(
            page = 0,
            results = listOf(getDummyResultModel()),
            totalPages = 0,
            totalResults = 0
        )
    }

    private fun getDummyResultModel(): ResultDomainModel {
        return ResultDomainModel(
            adult = false,
            backdropPath = "",
            genreIds = listOf(),
            id = 0,
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            releaseDate = "2023-03-07",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
            rating = 0.0
        )
    }
}