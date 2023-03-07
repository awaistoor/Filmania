package com.yaasir.filmania.data

import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.data.network.model.home.toDomainModel
import com.yaasir.filmania.domain.model.detail.DetailDomainModel
import com.yaasir.filmania.domain.model.home.MoviesDomainModel
import com.yaasir.filmania.domain.repository.home.HomeRepository
import javax.inject.Inject

/**
 * [HomeRepositoryImp]
 * Repository implementation class to implement all repo functions for home screen
 * @param apiService as [FilmaniaApiService]
 * Note: if we have local db, we can add it is as a data source over here and we can implement its functions as well
 */
class HomeRepositoryImp @Inject constructor(private val apiService: FilmaniaApiService) :
    HomeRepository {
    /**
     * [getTrendingMovies]
     * A function get all trending movies from [apiService]
     * @return [MoviesDomainModel]
     */
    override suspend fun getTrendingMovies(): MoviesDomainModel {
        return apiService.getMovies().toDomainModel()
    }
}