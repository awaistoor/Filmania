package com.yaasir.filmania.presentation.home.model

import com.yaasir.filmania.domain.model.home.MoviesDomainModel

/**
 * [MoviesUiModel]
 * UI model for presentation layer
 */
data class MoviesUiModel(
    val page: Int,
    val results: List<ResultUiModel>,
    val totalPages: Int,
    val totalResults: Int
)

/**
 * [MoviesDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [MoviesUiModel]
 */
fun MoviesDomainModel.toUiModel(): MoviesUiModel {
    return MoviesUiModel(
        page = page,
        results = results.map { it.toUiModel() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}