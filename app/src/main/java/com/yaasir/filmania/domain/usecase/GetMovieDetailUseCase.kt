package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.model.detail.DetailDomainModel
import com.yaasir.filmania.domain.repository.detail.DetailRepository
import javax.inject.Inject

/**
 * [GetMovieDetailUseCase]
 * A use case implementation for fetching movie detail by providing movie id
 * it also add rating to the model class and convert release date to pretty format
 * @param detailRepository as [DetailRepository]
 * @param formatDateToReadableUseCase as [FormatDateToReadableUseCase]
 * @param convertVoteToRatingUseCase as [ConvertVoteToRatingUseCase]
 * the [invoke] function with take [Int] as parameter and will return [DetailDomainModel]
 */
class GetMovieDetailUseCase @Inject constructor(
    private val detailRepository: DetailRepository,
    private val formatDateToReadableUseCase: FormatDateToReadableUseCase,
    private val convertVoteToRatingUseCase: ConvertVoteToRatingUseCase
) {
    suspend operator fun invoke(movieId: Int): DetailDomainModel {
        val movieDetail = detailRepository.getMovieDetail(movieId = movieId)
        movieDetail.rating = convertVoteToRatingUseCase(movieDetail.voteAverage)
        movieDetail.releaseDate = formatDateToReadableUseCase(movieDetail.releaseDate)
        return movieDetail
    }
}