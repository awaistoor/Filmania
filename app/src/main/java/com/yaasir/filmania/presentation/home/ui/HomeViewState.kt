package com.yaasir.filmania.presentation.home.ui

import com.yaasir.filmania.presentation.home.model.MoviesUiModel

sealed class InitialFetchViewState {
    object Loading : InitialFetchViewState()
    data class Success(val moviesUiModel: MoviesUiModel) : InitialFetchViewState()
    object Error : InitialFetchViewState()
}