package com.yaasir.filmania.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.model.home.toUiModel
import com.yaasir.filmania.domain.usecase.GetMoviesListUseCase
import com.yaasir.filmania.presentation.home.ui.InitialFetchViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesListUseCase: GetMoviesListUseCase) :
    ViewModel() {
    val initialFetchUiState = MutableLiveData<InitialFetchViewState>()

    init {
        getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        initialFetchUiState.postValue(InitialFetchViewState.Loading)
        try {
            val result = getMoviesListUseCase.invoke()
            initialFetchUiState.postValue(InitialFetchViewState.Success(result.toUiModel()))
        } catch (ex: Exception) {
            ex.printStackTrace()
            initialFetchUiState.postValue(InitialFetchViewState.Error)
        }
    }

}