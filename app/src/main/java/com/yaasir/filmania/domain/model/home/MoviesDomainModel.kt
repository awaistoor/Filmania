package com.yaasir.filmania.domain.model.home

/**
 * [MoviesDomainModel]
 * Movies model for domain layer
 */
data class MoviesDomainModel(
    val page: Int,
    val results: List<ResultDomainModel>,
    val totalPages: Int,
    val totalResults: Int
)
