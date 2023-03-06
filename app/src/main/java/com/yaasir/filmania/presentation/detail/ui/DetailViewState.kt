package com.yaasir.filmania.presentation.detail.ui

import com.yaasir.filmania.presentation.detail.model.DetailUiModel

sealed class InitialDetailFetchViewState{
    object Loading : InitialDetailFetchViewState()
    data class Success(val detailUiModel: DetailUiModel): InitialDetailFetchViewState()
    object Error: InitialDetailFetchViewState()
}
