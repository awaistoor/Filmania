package com.yaasir.filmania.data.network.apiservice

import com.yaasir.filmania.data.network.model.detail.DetailRemote
import com.yaasir.filmania.data.network.model.home.MoviesRemote
import com.yaasir.filmania.utils.API
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * [FilmaniaApiService]
 * Interface class for calling api request
 */
interface FilmaniaApiService {
    /**
     * [getMovies]
     * function to get movies list from server
     * @return [MoviesRemote]
     */
    @GET(API.GET_MOVIES)
    suspend fun getMovies(): MoviesRemote

    /**
     * [getMovieDetail]
     * function to get movie detail by movie id from server
     * @param movieId as [Int]
     * @return [DetailRemote]
     */
    @GET(API.GET_MOVIE_DETAIL + "/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): DetailRemote

}