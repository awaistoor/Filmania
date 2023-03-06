package com.yaasir.filmania.data.network

import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.data.network.model.home.toDomainModel
import com.yaasir.filmania.domain.model.home.MoviesDomainModel
import com.yaasir.filmania.domain.repository.home.HomeRepository
import javax.inject.Inject

class HomeRepositoryImp @Inject constructor(private val apiService: FilmaniaApiService) :
    HomeRepository {
    override suspend fun getTrendingMovies(): MoviesDomainModel {
        return apiService.getMovies().toDomainModel()
    }
}