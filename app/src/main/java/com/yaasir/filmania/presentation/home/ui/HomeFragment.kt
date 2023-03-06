package com.yaasir.filmania.presentation.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yaasir.filmania.R
import com.yaasir.filmania.databinding.FragmentHomeBinding
import com.yaasir.filmania.presentation.home.adapter.MoviesListAdapter
import com.yaasir.filmania.presentation.home.model.MoviesUiModel
import com.yaasir.filmania.presentation.home.model.ResultUiModel
import com.yaasir.filmania.presentation.home.viewmodel.HomeViewModel
import com.yaasir.filmania.utils.makeGone
import com.yaasir.filmania.utils.makeVisible
import com.yaasir.filmania.utils.showSnackBar
import com.yaasir.filmania.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter: MoviesListAdapter by lazy {
        MoviesListAdapter {
            showToast(context, it.title)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        observeUiState()
    }

    private fun setupAdapter() {
        binding.rvMoviesList.adapter = adapter
    }

    private fun observeUiState() {
        viewModel.initialFetchUiState.observe(viewLifecycleOwner) {
            when (it) {
                InitialFetchViewState.Error -> {
                    showError()
                }
                InitialFetchViewState.Loading -> {
                    showLoading()
                }
                is InitialFetchViewState.Success -> {
                    showData(it.moviesUiModel.results)
                }
            }
        }
    }

    private fun showLoading() {
        with(binding) {
            pbLoader.makeVisible()
            rvMoviesList.makeGone()
        }
    }

    private fun showData(moviesList: List<ResultUiModel>) {
        with(binding) {
            pbLoader.makeGone()
            rvMoviesList.makeVisible()
            adapter.submitList(moviesList)
        }
    }

    private fun showError() {
        with(binding) {
            pbLoader.makeGone()
            rvMoviesList.makeGone()
            showSnackBar(binding.root, getString(R.string.error_something_went_wrong))
        }
    }
}