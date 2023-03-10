package com.yaasir.filmania.presentation.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yaasir.filmania.R
import com.yaasir.filmania.databinding.FragmentDetailBinding
import com.yaasir.filmania.domain.usecase.ConvertNumberIntoPrettyCurrencyUseCase
import com.yaasir.filmania.presentation.detail.model.DetailUiModel
import com.yaasir.filmania.presentation.detail.viewmodel.DetailViewModel
import com.yaasir.filmania.utils.loadImage
import com.yaasir.filmania.utils.makeGone
import com.yaasir.filmania.utils.makeVisible
import com.yaasir.filmania.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {
    @Inject
    lateinit var convertNumberIntoPrettyCurrencyUseCase: ConvertNumberIntoPrettyCurrencyUseCase
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        observeUiState()
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

    }

    private fun observeUiState() {
        viewModel.detailViewState.observe(viewLifecycleOwner) {
            when (it) {
                DetailViewState.Error -> {
                    showError()
                }
                DetailViewState.Loading -> {
                    showLoading()
                }
                is DetailViewState.Success -> {
                    showData(it.detailUiModel)
                }
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            pbLoader.makeVisible()
            nsvContainer.makeGone()
        }
    }

    private fun showData(detailUiModel: DetailUiModel) {
        with(binding) {
            pbLoader.makeGone()
            nsvContainer.makeVisible()
            ivBanner.loadImage(detailUiModel.backdropPath)
            ivMovieImg.loadImage(detailUiModel.posterPath)
            tvMovieName.text = detailUiModel.title
            tvTagline.text = detailUiModel.tagline
            tvRating.text = String.format("%.1f", detailUiModel.voteAverage)
            tvDetail.text = detailUiModel.overview
            tvGenre.text = detailUiModel.genres.joinToString { it.name }
            tvReleaseDate.text = detailUiModel.releaseDate
            tvRuntimeMin.text = "${detailUiModel.runtime} mins"
            tvBudgetValue.text = "USD ${convertNumberIntoPrettyCurrencyUseCase(detailUiModel.budget)}"
            tvRevenueValue.text = "USD ${convertNumberIntoPrettyCurrencyUseCase(detailUiModel.revenue)}"
            tvLanguagesValue.text =
                detailUiModel.spokenLanguages.joinToString { it.englishName }
            rbRating.rating = detailUiModel.rating.toFloat()
        }
    }

    private fun showError() {
        with(binding) {
            pbLoader.makeGone()
            nsvContainer.makeGone()
            showSnackBar(binding.root, getString(R.string.error_something_went_wrong))
        }
    }


}