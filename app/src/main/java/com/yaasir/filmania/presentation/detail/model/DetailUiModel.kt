package com.yaasir.filmania.presentation.detail.model

import com.yaasir.filmania.domain.model.detail.DetailDomainModel

/**
 * [DetailUiModel]
 * UI model for presentation layer
 */
data class DetailUiModel(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any?,
    val budget: Int,
    val genres: List<GenreUiModel>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyUiModel>,
    val productionCountries: List<ProductionCountryUiModel>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageUiModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
    val rating: Double
)

/**
 * [DetailDomainModel.toUiModel]
 * Extension function to convert domain model to UI model
 * @return [DetailUiModel]
 */
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