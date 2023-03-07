package com.yaasir.filmania.data.network.model.home


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.home.MoviesDomainModel

/**
 * [MoviesRemote]
 * Remote model for network layer
 */
data class MoviesRemote(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<ResultRemote>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

/**
 * [MoviesRemote.toDomainModel]
 * Extension function to convert remote model to domain model
 * @return [MoviesDomainModel]
 */
fun MoviesRemote.toDomainModel(): MoviesDomainModel {
    return MoviesDomainModel(
        page = page,
        results = results.map { it.toDomainModel() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}