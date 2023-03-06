package com.yaasir.filmania.domain.usecase

import com.yaasir.filmania.domain.model.detail.DetailDomainModel
import com.yaasir.filmania.domain.repository.detail.DetailRepository
import javax.inject.Inject

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