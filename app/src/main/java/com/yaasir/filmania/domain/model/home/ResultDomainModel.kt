package com.yaasir.filmania.domain.model.home

/**
 * [ResultDomainModel]
 * Result model for domain layer
 */
data class ResultDomainModel(
    val adult: Boolean,
    val backdropPath: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String?,
    var releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    var rating: Double
)