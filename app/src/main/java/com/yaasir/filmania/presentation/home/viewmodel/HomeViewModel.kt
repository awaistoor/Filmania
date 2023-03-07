package com.yaasir.filmania.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.usecase.GetMoviesListUseCase
import com.yaasir.filmania.presentation.home.model.toUiModel
import com.yaasir.filmania.presentation.home.ui.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesListUseCase: GetMoviesListUseCase) :
    ViewModel() {
    // a mutable live data to observe the UI state
    private val homeUiState = MutableLiveData<HomeViewState>()

    // a live data which will expose view state to the view
    val homeViewState: LiveData<HomeViewState> = homeUiState

    init {
        // request data on start of this view model
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        // emit UI state to loading
        homeUiState.postValue(HomeViewState.Loading)
        try {
            val result = getMoviesListUseCase.invoke()
            // emit UI state to Success with UI model list
            homeUiState.postValue(HomeViewState.Success(result.toUiModel()))
        } catch (ex: Exception) {
            ex.printStackTrace()
            // emit UI state to error
            homeUiState.postValue(HomeViewState.Error)
        }
    }

}