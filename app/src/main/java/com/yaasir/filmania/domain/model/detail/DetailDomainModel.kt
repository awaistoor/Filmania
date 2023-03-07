package com.yaasir.filmania.domain.model.detail


/**
 * [DetailDomainModel]
 * Movie detail model for domain layer
 */
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