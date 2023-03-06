package com.yaasir.filmania.domain.repository.detail

import com.yaasir.filmania.domain.model.detail.DetailDomainModel

interface DetailRepository {
    suspend fun getMovieDetail(movieId: Int): DetailDomainModel
}