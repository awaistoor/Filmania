package com.yaasir.filmania.presentation.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.usecase.GetMoviesListUseCase
import com.yaasir.filmania.presentation.home.model.toUiModel
import com.yaasir.filmania.presentation.home.ui.InitialFetchViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesListUseCase: GetMoviesListUseCase) :
    ViewModel() {
    // a mutable live data to observe the UI state in View
    val initialFetchUiState = MutableLiveData<InitialFetchViewState>()

    init {
        // request data on start of this view model
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        // emit UI state to loading
        initialFetchUiState.postValue(InitialFetchViewState.Loading)
        try {
            val result = getMoviesListUseCase.invoke()
            // emit UI state to Success with UI model list
            initialFetchUiState.postValue(InitialFetchViewState.Success(result.toUiModel()))
        } catch (ex: Exception) {
            ex.printStackTrace()
            // emit UI state to error
            initialFetchUiState.postValue(InitialFetchViewState.Error)
        }
    }

}