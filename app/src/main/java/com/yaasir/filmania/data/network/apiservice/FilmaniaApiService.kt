package com.yaasir.filmania.data.network.apiservice

import com.yaasir.filmania.data.network.model.home.MoviesRemote
import com.yaasir.filmania.utils.API
import retrofit2.http.GET

interface FilmaniaApiService {
    @GET(API.GET_MOVIES)
    suspend fun getMovies(): MoviesRemote
}