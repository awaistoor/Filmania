package com.yaasir.filmania.presentation.home.model

data class MoviesUiModel(
    val page: Int,
    val results: List<ResultUiModel>,
    val totalPages: Int,
    val totalResults: Int
)