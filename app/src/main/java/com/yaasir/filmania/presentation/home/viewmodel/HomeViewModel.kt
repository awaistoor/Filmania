package com.yaasir.filmania.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.usecase.GetMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesListUseCase: GetMoviesListUseCase) :
    ViewModel() {

        fun getMovies(){
            viewModelScope.launch {
                try {
                    val values = getMoviesListUseCase.invoke()
                    println(values)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
        }
}