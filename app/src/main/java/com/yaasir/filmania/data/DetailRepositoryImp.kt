package com.yaasir.filmania.data

import com.yaasir.filmania.data.network.apiservice.FilmaniaApiService
import com.yaasir.filmania.data.network.model.detail.toDomainModel
import com.yaasir.filmania.domain.model.detail.DetailDomainModel
import com.yaasir.filmania.domain.repository.detail.DetailRepository
import javax.inject.Inject

/**
 * [DetailRepositoryImp]
 * Repository implementation class to implement all repo functions for movies detail screen
 * @param apiService as [FilmaniaApiService]
 * Note: if we have local db, we can add it is as a data source over here and we can implement its functions as well
 */
class DetailRepositoryImp @Inject constructor(private val apiService: FilmaniaApiService) :
    DetailRepository {

    /**
     * [getMovieDetail]
     * A function get movie detail from the [apiService] by providing movie id
     * @param movieId as [Int]
     * @return [DetailDomainModel]
     */
    override suspend fun getMovieDetail(movieId: Int): DetailDomainModel {
        return apiService.getMovieDetail(movieId = movieId).toDomainModel()
    }
}