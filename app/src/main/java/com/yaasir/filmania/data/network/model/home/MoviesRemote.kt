package com.yaasir.filmania.data.network.model.home


import com.google.gson.annotations.SerializedName
import com.yaasir.filmania.domain.model.home.MoviesDomainModel

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

fun MoviesRemote.toDomainModel(): MoviesDomainModel {
    return MoviesDomainModel(
        page = page,
        results = results.map { it.toDomainModel() },
        totalPages = totalPages,
        totalResults = totalResults
    )
}