package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.model.home.MoviesDomainModel
import com.yaasir.filmania.domain.repository.home.HomeRepository
import javax.inject.Inject

/**
 * [GetMoviesListUseCase]
 * A use case implementation for fetching all movies from server
 * it also add rating to the model class and convert release date to pretty format
 * @param homeRepository as [HomeRepository]
 * @param formatDateToYearUseCase as [FormatDateToYearUseCase]
 * @param convertVoteToRatingUseCase as [ConvertVoteToRatingUseCase]
 * the [invoke] function with return [MoviesDomainModel]
 */
class GetMoviesListUseCase @Inject constructor(
    private val homeRepository: HomeRepository,
    private val formatDateToYearUseCase: FormatDateToYearUseCase,
    private val convertVoteToRatingUseCase: ConvertVoteToRatingUseCase
) {
    suspend operator fun invoke(): MoviesDomainModel {
        val movies = homeRepository.getTrendingMovies()
        movies.results.map {
            it.releaseDate = formatDateToYearUseCase(it.releaseDate)
            it.rating = convertVoteToRatingUseCase(it.voteAverage)
        }
        return movies
    }
}