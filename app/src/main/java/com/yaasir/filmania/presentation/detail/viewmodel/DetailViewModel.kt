package com.yaasir.filmania.presentation.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaasir.filmania.domain.usecase.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {
    fun getMoviesDetail() {
        viewModelScope.launch {
            try {
                val values = getMovieDetailUseCase.invoke(164558)
                println(values)
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}