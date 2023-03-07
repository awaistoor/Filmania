package com.yaasir.filmania.domain.repository.home

import com.yaasir.filmania.domain.model.home.MoviesDomainModel

/**
 * [HomeRepository]
 * interface for HomeRepository in the domain layer
 * Note: We can add local db functions over here as well
 */
interface HomeRepository {
    suspend fun getTrendingMovies(): MoviesDomainModel
}