package com.yaasir.filmania.presentation.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.usecase.GetMovieDetailUseCase
import com.yaasir.filmania.presentation.detail.model.toUiModel
import com.yaasir.filmania.presentation.detail.ui.DetailFragmentArgs
import com.yaasir.filmania.presentation.detail.ui.InitialDetailFetchViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    // a mutable live data to observe the UI state in View
    val initialFetchViewState = MutableLiveData<InitialDetailFetchViewState>()

    // args to get arguments from DetailFragment
    private val args = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle = savedStateHandle)

    init {
        // request data on start of this view model
        getMoviesDetail(args.movieId)
    }

    private fun getMoviesDetail(movieId: Int) =
        viewModelScope.launch {
            // emit UI state to loading
            initialFetchViewState.postValue(InitialDetailFetchViewState.Loading)
            try {
                val result = getMovieDetailUseCase.invoke(movieId = movieId)
                // emit UI state to Success with UI model list
                initialFetchViewState.postValue(InitialDetailFetchViewState.Success(result.toUiModel()))
            } catch (ex: Exception) {
                ex.printStackTrace()
                // emit UI state to error
                initialFetchViewState.postValue(InitialDetailFetchViewState.Error)
            }
        }

}