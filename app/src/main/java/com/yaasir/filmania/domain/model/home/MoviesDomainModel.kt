package com.yaasir.filmania.domain.model.home

import com.yaasir.filmania.presentation.home.model.MoviesUiModel

data class MoviesDomainModel(
    val page: Int,
    val results: List<ResultDomainModel>,
    val totalPages: Int,
    val totalResults: Int
)

fun MoviesDomainModel.toUiModel(): MoviesUiModel {
    return MoviesUiModel(
        page = page,
        results = results.map { it.toUiModel() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}