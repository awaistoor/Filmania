package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.data.network.model.detail.*
import com.yaasir.filmania.domain.model.detail.*
import com.yaasir.filmania.domain.repository.detail.DetailRepository
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
class GetMovieDetailUseCaseTest {

    private lateinit var SUT: GetMovieDetailUseCase

    @Mock
    private lateinit var detailRepository: DetailRepository

    @Mock
    private lateinit var formatDateToReadableUseCase: FormatDateToReadableUseCase

    @Mock
    private lateinit var convertVoteToRatingUseCase: ConvertVoteToRatingUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        SUT = GetMovieDetailUseCase(
            detailRepository = detailRepository,
            formatDateToReadableUseCase = formatDateToReadableUseCase,
            convertVoteToRatingUseCase = convertVoteToRatingUseCase
        )
    }

    @Test
    fun testInvoke() = runBlocking {
        // region Arrange
        val model = getDummyDetailModel()
        Mockito.`when`(detailRepository.getMovieDetail(getDummyMovieId())).thenReturn(model)
        Mockito.`when`(formatDateToReadableUseCase(getDummyDate()))
            .thenReturn(getDummyFormattedDate())
        Mockito.`when`(convertVoteToRatingUseCase(0.0)).thenReturn(0.0)
        // endregion

        // region Assert
        Assert.assertEquals(SUT.invoke(getDummyMovieId()), model)
        // endregion
    }

    @Test
    fun `when invoke, verify detailRepository and formatDateToReadableUseCase and convertVoteToRatingUseCase are invoked`(): Unit =
        runBlocking {
            // region Arrange
            val model = getDummyDetailModel()
            Mockito.`when`(detailRepository.getMovieDetail(getDummyMovieId())).thenReturn(model)
            Mockito.`when`(formatDateToReadableUseCase(getDummyDate()))
                .thenReturn(getDummyFormattedDate())
            Mockito.`when`(convertVoteToRatingUseCase(0.0)).thenReturn(0.0)
            // endregion

            // region Act
            SUT.invoke(getDummyMovieId())
            // endregion

            // region Assert
            Mockito.verify(detailRepository).getMovieDetail(getDummyMovieId())
            Mockito.verify(formatDateToReadableUseCase).invoke(getDummyDate())
            Mockito.verify(convertVoteToRatingUseCase).invoke(0.0)
            // endregion
        }

    private fun getDummyFormattedDate(): String = "March 20, 2023"

    private fun getDummyDate(): String = "2023-03-07"

    private fun getDummyDetailModel(): DetailDomainModel {
        return DetailDomainModel(
            adult = false,
            backdropPath = "",
            belongsToCollection = null,
            budget = 0,
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
            releaseDate = "2023-03-07",
            revenue = 0,
            runtime = 0,
            spokenLanguages = listOf(getDummySpokenLanguagesModel()),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = 0,
            rating = 0.0
        )
    }

    private fun getDummySpokenLanguagesModel(): SpokenLanguageDomainModel =
        SpokenLanguageDomainModel(englishName = "", iso6391 = "", name = "")

    private fun getDummyProductionCountriesModel(): ProductionCountryDomainModel =
        ProductionCountryDomainModel(iso31661 = "", name = "")

    private fun getDummyProductionCompaniesModel(): ProductionCompanyDomainModel =
        ProductionCompanyDomainModel(id = 0, logoPath = "", name = "", originCountry = "")

    private fun getDummyGenreModel(): GenreDomainModel = GenreDomainModel(id = 0, name = "")

    private fun getDummyMovieId(): Int = 0
}