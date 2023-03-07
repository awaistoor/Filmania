package com.yaasir.filmania.presentation.home.ui

import com.yaasir.filmania.presentation.home.model.MoviesUiModel
import com.yaasir.filmania.presentation.home.ui.HomeViewState.*

/**
 * [HomeViewState]
 * View state for initial fetch of data for [HomeFragment]
 * consists of [Loading] [Success] [Error]
 */
sealed class HomeViewState {
    object Loading : HomeViewState()
    data class Success(val moviesUiModel: MoviesUiModel) : HomeViewState()
    object Error : HomeViewState()
}