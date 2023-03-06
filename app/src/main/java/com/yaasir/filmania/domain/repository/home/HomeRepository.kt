package com.yaasir.filmania.domain.repository.home

import com.yaasir.filmania.domain.model.home.MoviesDomainModel

interface HomeRepository {
    suspend fun getTrendingMovies(): MoviesDomainModel
}