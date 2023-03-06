package com.yaasir.filmania.domain.model.detail

import com.yaasir.filmania.presentation.detail.model.DetailUiModel


data class DetailDomainModel(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any?,
    val budget: Int,
    val genres: List<GenreDomainModel>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyDomainModel>,
    val productionCountries: List<ProductionCountryDomainModel>,
    var releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDomainModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    var rating: Double
)

fun DetailDomainModel.toUiModel(): DetailUiModel {
    return DetailUiModel(
        adult = adult,
        backdropPath = backdropPath,
        belongsToCollection = belongsToCollection,
        budget = budget,
        genres = genres.map { it.toUiModel() },
        homepage = homepage,
        id = id,
        imdbId = imdbId,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterPath = posterPath,
        productionCompanies = productionCompanies.map { it.toUiModel() },
        productionCountries = productionCountries.map { it.toUiModel() },
        releaseDate = releaseDate,
        revenue = revenue,
        runtime = runtime,
        spokenLanguages = spokenLanguages.map { it.toUiModel() },
        status = status,
        tagline = tagline,
        title = title,
        video = video,
        voteAverage = voteAverage,
        voteCount = voteCount,
        rating = rating
    )
}