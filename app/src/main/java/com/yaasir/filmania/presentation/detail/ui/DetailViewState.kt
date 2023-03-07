package com.yaasir.filmania.presentation.detail.ui

import com.yaasir.filmania.presentation.detail.model.DetailUiModel
import com.yaasir.filmania.presentation.detail.ui.DetailViewState.*

/**
 * [DetailViewState]
 * View state for initial fetch of data for [DetailFragment]
 * consists of [Loading] [Success] [Error]
 */
sealed class DetailViewState{
    object Loading : DetailViewState()
    data class Success(val detailUiModel: DetailUiModel): DetailViewState()
    object Error: DetailViewState()
}
