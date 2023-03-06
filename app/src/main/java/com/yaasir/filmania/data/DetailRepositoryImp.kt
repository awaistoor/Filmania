package com.yaasir.filmania.data

import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.data.network.model.detail.toDomainModel
import com.yaasir.filmania.domain.model.detail.DetailDomainModel
import com.yaasir.filmania.domain.repository.detail.DetailRepository
import javax.inject.Inject

class DetailRepositoryImp @Inject constructor(private val apiService: FilmaniaApiService) :
    DetailRepository {
    override suspend fun getMovieDetail(movieId: Int): DetailDomainModel {
        return apiService.getMovieDetail(movieId = movieId).toDomainModel()
    }
}