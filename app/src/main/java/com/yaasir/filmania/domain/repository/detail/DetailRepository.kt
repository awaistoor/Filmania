package com.yaasir.filmania.domain.repository.detail

import com.yaasir.filmania.domain.model.detail.DetailDomainModel

/**
 * [DetailRepository]
 * interface for DetailRepository in the domain layer
 * Note: We can add local db functions over here as well
 */
interface DetailRepository {
    suspend fun getMovieDetail(movieId: Int): DetailDomainModel
}