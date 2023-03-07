package com.yaasir.filmania.data

import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.data.network.model.home.MoviesRemote
import com.yaasir.filmania.data.network.model.home.ResultRemote
import com.yaasir.filmania.data.network.model.home.toDomainModel
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
class HomeRepositoryImpTest {

    private lateinit var SUT: HomeRepositoryImp

    @Mock
    private lateinit var apiService: FilmaniaApiService

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = HomeRepositoryImp(apiService = apiService)
    }

    @Test
    fun testGetTrendingMovies() = runBlocking {
        Mockito.`when`(apiService.getMovies()).thenReturn(getDummyMoviesModel())
        Assert.assertEquals(apiService.getMovies().toDomainModel(), SUT.getTrendingMovies())
    }

    private fun getDummyMoviesModel(): MoviesRemote {
        return MoviesRemote(page = 0, results = listOf(getDummyResultModel()), totalPages = 0, totalResults = 0)
    }

    private fun getDummyResultModel(): ResultRemote {
        return ResultRemote(
            adult = false,
            backdropPath = "",
            genreIds = listOf(),
            id = 0,
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            releaseDate = "",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
        )
    }

}