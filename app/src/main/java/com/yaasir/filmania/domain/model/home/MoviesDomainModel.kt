package com.yaasir.filmania.domain.model.home

data class MoviesDomainModel(
    val page: Int,
    val results: List<ResultDomainModel>,
    val totalPages: Int,
    val totalResults: Int
)