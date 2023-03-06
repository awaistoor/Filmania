package com.yaasir.filmania.data.network.apiservice

import com.yaasir.filmania.data.network.model.detail.DetailRemote
import com.yaasir.filmania.data.network.model.home.MoviesRemote
import com.yaasir.filmania.utils.API
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmaniaApiService {
    @GET(API.GET_MOVIES)
    suspend fun getMovies(): MoviesRemote

    @GET(API.GET_MOVIE_DETAIL + "/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): DetailRemote

}