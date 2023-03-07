package com.yaasir.filmania.presentation.detail.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.yaasir.filmania.domain.model.detail.*
import com.yaasir.filmania.domain.usecase.GetMovieDetailUseCase
import com.yaasir.filmania.presentation.detail.model.toUiModel
import com.yaasir.filmania.presentation.detail.ui.InitialDetailFetchViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    private lateinit var SUT: DetailViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getMovieDetailUseCase: GetMovieDetailUseCase

    @Mock
    private lateinit var savedStateHandle: SavedStateHandle

    @Mock
    private lateinit var initialFetchViewStateObserver: Observer<InitialDetailFetchViewState>

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `on viewModel load,invoke getMovieDetailUseCase, return success with data`() = runTest {
        // region Arrange
        val model = getDummyDetailModel()
        Mockito.`when`(getMovieDetailUseCase(getDummyMovieId())).thenReturn(model)
        // endregion

        // region Act
        SUT = DetailViewModel(getMovieDetailUseCase, savedStateHandle)
        SUT.initialFetchViewState.observeForever(initialFetchViewStateObserver)
        // endregion

        // region Assert
        Mockito.verify(getMovieDetailUseCase).invoke(getDummyMovieId())
        Mockito.verify(initialFetchViewStateObserver)
            .onChanged(InitialDetailFetchViewState.Success(model.toUiModel()))
        SUT.initialFetchViewState.removeObserver(initialFetchViewStateObserver)
        // endregion
    }

    @Test
    fun `on viewModel load,invoke getMovieDetailUseCase, throw exception, return error`() = runTest {
        // region Arrange
        Mockito.`when`(getMovieDetailUseCase(getDummyMovieId())).thenThrow(RuntimeException())
        // endregion

        // region Act
        SUT = DetailViewModel(getMovieDetailUseCase, savedStateHandle)
        SUT.initialFetchViewState.observeForever(initialFetchViewStateObserver)
        // endregion

        // region Assert
        Mockito.verify(getMovieDetailUseCase).invoke(getDummyMovieId())
        Mockito.verify(initialFetchViewStateObserver)
            .onChanged(InitialDetailFetchViewState.Error)
        SUT.initialFetchViewState.removeObserver(initialFetchViewStateObserver)
        // endregion
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

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