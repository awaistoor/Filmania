package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.model.home.MoviesDomainModel
import com.yaasir.filmania.domain.repository.home.HomeRepository
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    private val formatDateUseCase: FormatDateUseCase,
    private val convertVoteToRatingUseCase: ConvertVoteToRatingUseCase
) {
    suspend operator fun invoke(): MoviesDomainModel {
        val movies = homeRepository.getTrendingMovies()
        movies.results.map {
            it.releaseDate = formatDateUseCase(it.releaseDate)
            it.rating = convertVoteToRatingUseCase(it.voteAverage)
        }
        return movies
    }
}