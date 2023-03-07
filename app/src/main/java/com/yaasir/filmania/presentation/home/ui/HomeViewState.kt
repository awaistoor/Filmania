package com.yaasir.filmania.presentation.home.ui

import com.yaasir.filmania.presentation.home.model.MoviesUiModel
import com.yaasir.filmania.presentation.home.ui.InitialFetchViewState.*

/**
 * [InitialFetchViewState]
 * View state for initial fetch of data for [HomeFragment]
 * consists of [Loading] [Success] [Error]
 */
sealed class InitialFetchViewState {
    object Loading : InitialFetchViewState()
    data class Success(val moviesUiModel: MoviesUiModel) : InitialFetchViewState()
    object Error : InitialFetchViewState()
}