package com.yaasir.filmania.presentation.home.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.yaasir.filmania.domain.model.home.MoviesDomainModel
import com.yaasir.filmania.domain.model.home.ResultDomainModel
import com.yaasir.filmania.domain.usecase.GetMoviesListUseCase
import com.yaasir.filmania.presentation.home.model.toUiModel
import com.yaasir.filmania.presentation.home.ui.HomeViewState
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
class HomeViewModelTest {
    private lateinit var SUT: HomeViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getMoviesListUseCase: GetMoviesListUseCase

    @Mock
    private lateinit var homeViewStateObserver: Observer<HomeViewState>

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `on viewModel load, invoke getMoviesListUseCase, return success with data`() = runTest {
        // region Arrange
        val model = getDummyMoviesModel()
        Mockito.`when`(getMoviesListUseCase()).thenReturn(model)
        // endregion

        // region Act
        SUT = HomeViewModel(getMoviesListUseCase)
        SUT.homeViewState.observeForever(homeViewStateObserver)
        // endregion

        // region Assert
        Mockito.verify(getMoviesListUseCase).invoke()
        Mockito.verify(homeViewStateObserver)
            .onChanged(HomeViewState.Success(model.toUiModel()))
        SUT.homeViewState.removeObserver(homeViewStateObserver)
        // endregion
    }

    @Test
    fun `on viewModel load, invoke getMoviesListUseCase, throw exception, return error`() =
        runTest {
            // region Arrange
            Mockito.`when`(getMoviesListUseCase()).thenThrow(RuntimeException())
            // endregion

            // region Act
            SUT = HomeViewModel(getMoviesListUseCase)
            SUT.homeViewState.observeForever(homeViewStateObserver)
            // endregion

            // region Assert
            Mockito.verify(getMoviesListUseCase).invoke()
            Mockito.verify(homeViewStateObserver)
                .onChanged(HomeViewState.Error)
            SUT.homeViewState.removeObserver(homeViewStateObserver)
            // endregion
        }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

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