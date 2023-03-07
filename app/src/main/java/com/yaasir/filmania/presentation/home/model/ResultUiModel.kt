package com.yaasir.filmania.presentation.home.model

import com.yaasir.filmania.domain.model.home.ResultDomainModel

/**
 * [ResultUiModel]
 * UI model for presentation layer
 */
data class ResultUiModel(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val rating: Double
)

/**
 * [ResultDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [ResultUiModel]
 */
fun ResultDomainModel.toUiModel(): ResultUiModel {
    return ResultUiModel(
        adult = adult,
        backdropPath = backdropPath,
        genreIds = genreIds,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        rating = rating
    )
}