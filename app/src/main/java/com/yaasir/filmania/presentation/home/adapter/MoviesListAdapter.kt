package com.yaasir.filmania.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yaasir.filmania.databinding.LayoutHomeMovieListItemBinding
import com.yaasir.filmania.presentation.home.model.ResultUiModel
import com.yaasir.filmania.utils.loadImage

class MoviesListAdapter(private val onItemClicked: (ResultUiModel) -> Unit) :
    ListAdapter<ResultUiModel, MoviesListAdapter.ViewHolder>(MoviesListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutHomeMovieListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(private val binding: LayoutHomeMovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ResultUiModel) {
            with(binding) {
                tvMovieName.text = item.title
                tvYear.text = item.releaseDate
                tvRating.text = item.voteAverage.toString()
                ivMovieImg.loadImage(item.posterPath)
                rbRating.rating = item.rating.toFloat()
                cvItemContainer.setOnClickListener { onItemClicked(item) }
            }

        }
    }

    class MoviesListDiffUtil : DiffUtil.ItemCallback<ResultUiModel>() {
        override fun areItemsTheSame(oldItem: ResultUiModel, newItem: ResultUiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResultUiModel, newItem: ResultUiModel): Boolean {
            return oldItem.id == newItem.id
        }

    }
}