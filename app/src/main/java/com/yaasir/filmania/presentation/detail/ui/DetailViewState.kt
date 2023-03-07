package com.yaasir.filmania.presentation.detail.ui

import com.yaasir.filmania.presentation.detail.model.DetailUiModel
import com.yaasir.filmania.presentation.detail.ui.InitialDetailFetchViewState.*

/**
 * [InitialDetailFetchViewState]
 * View state for initial fetch of data for [DetailFragment]
 * consists of [Loading] [Success] [Error]
 */
sealed class InitialDetailFetchViewState{
    object Loading : InitialDetailFetchViewState()
    data class Success(val detailUiModel: DetailUiModel): InitialDetailFetchViewState()
    object Error: InitialDetailFetchViewState()
}
