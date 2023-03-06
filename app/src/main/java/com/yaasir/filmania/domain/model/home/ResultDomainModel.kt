package com.yaasir.filmania.domain.model.home


data class ResultDomainModel(
    val adult: Boolean,
    val backdropPath: Any,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: Any,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)