package com.yaasir.filmania.utils

import com.yaasir.filmania.BuildConfig

object Configs {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val MOVIES_IMG_URL = "https://image.tmdb.org/t/p/original"
    const val API_KEY = BuildConfig.API_KEY
}

object API {
    const val GET_MOVIES = "discover/movie"
    const val GET_MOVIE_DETAIL = "movie"
}
