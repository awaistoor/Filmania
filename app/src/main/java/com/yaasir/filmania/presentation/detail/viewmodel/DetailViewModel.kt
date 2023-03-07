package com.yaasir.filmania.presentation.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.model.detail.toUiModel
import com.yaasir.filmania.domain.usecase.GetMovieDetailUseCase
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
    val initialFetchViewState = MutableLiveData<InitialDetailFetchViewState>()
    private val args = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle = savedStateHandle)

    init {
        getMoviesDetail(args.movieId)
    }

    private fun getMoviesDetail(movieId: Int) =
        viewModelScope.launch {
            initialFetchViewState.postValue(InitialDetailFetchViewState.Loading)
            try {
                val result = getMovieDetailUseCase.invoke(movieId = movieId)
                initialFetchViewState.postValue(InitialDetailFetchViewState.Success(result.toUiModel()))
            } catch (ex: Exception) {
                ex.printStackTrace()
                initialFetchViewState.postValue(InitialDetailFetchViewState.Error)
            }
        }

}