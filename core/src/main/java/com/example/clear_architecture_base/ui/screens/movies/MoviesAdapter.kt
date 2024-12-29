package com.example.clear_architecture_base.ui.screens.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.clear_architecture_base.core.R
import com.example.clear_architecture_base.core.databinding.ItemMovieBinding
import com.example.clear_architecture_base.ui.base.recyclerview.BasePagingAdapter
import com.example.clear_architecture_base.ui.base.recyclerview.BaseViewHolder
import com.example.domain.entities.MovieModel

class MoviesAdapter(private val onItemClick: (movieId: Int) -> Unit) :
    BasePagingAdapter<MovieModel, ItemMovieBinding>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ItemMovieBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
    }

    override fun registerEvents(holder: BaseViewHolder<ItemMovieBinding>) {
        super.registerEvents(holder)
        holder.binding.root.setOnClickListener {
            getItem(holder.bindingAdapterPosition)?.id?.let {
                onItemClick(it)
            }
        }
    }

    override fun bind(binding: ItemMovieBinding, position: Int, item: MovieModel?) {
        binding.movie = item
    }
}
