package com.yaasir.filmania.data

import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.data.network.model.detail.*
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
class DetailRepositoryImpTest {

    private lateinit var SUT: DetailRepositoryImp

    @Mock
    private lateinit var apiService: FilmaniaApiService

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = DetailRepositoryImp(apiService = apiService)
    }

    @Test
    fun testGetMovieDetail() = runBlocking {
        // region Arrange
        Mockito.`when`(apiService.getMovieDetail(getDummyMovieId()))
            .thenReturn(getDummyDetailModel())
        // endregion

        // region Assert
        Assert.assertEquals(
            apiService.getMovieDetail(getDummyMovieId()).toDomainModel(),
            SUT.getMovieDetail(getDummyMovieId())
        )
        // endregion
    }

    private fun getDummyDetailModel(): DetailRemote {
        return DetailRemote(
            adult = false,
            backdropPath = "",
            belongsToCollection = null,
            budget = 0.0,
            genres = listOf(getDummyGenreModel()),
            homepage = "",
            id = 0,
            imdbId = "",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            productionCompanies = listOf(getDummyProductionCompaniesModel()),
            productionCountries = listOf(getDummyProductionCountriesModel()),
            releaseDate = "",
            revenue = 0.0,
            runtime = 0,
            spokenLanguages = listOf(getDummySpokenLanguagesModel()),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
        )
    }

    private fun getDummySpokenLanguagesModel(): SpokenLanguageRemote =
        SpokenLanguageRemote(englishName = "", iso6391 = "", name = "")

    private fun getDummyProductionCountriesModel(): ProductionCountryRemote =
        ProductionCountryRemote(iso31661 = "", name = "")

    private fun getDummyProductionCompaniesModel(): ProductionCompanyRemote =
        ProductionCompanyRemote(id = 0, logoPath = "", name = "", originCountry = "")

    private fun getDummyGenreModel(): GenreRemote = GenreRemote(id = 0, name = "")


    private fun getDummyMovieId(): Int = 0
}