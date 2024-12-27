package com.example.clear_architecture_base.ui.screens.postlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.clear_architecture_base.core.R
import com.example.clear_architecture_base.core.databinding.ItemPostBinding
import com.example.clear_architecture_base.ui.base.recyclerview.BasePagingAdapter
import com.example.clear_architecture_base.ui.base.recyclerview.BaseViewHolder
import com.example.domain.entities.MovieModel

class PostsAdapter(private val onItemClick: () -> Unit) :
    BasePagingAdapter<MovieModel, ItemPostBinding>() {
    override fun createBinding(parent: ViewGroup, viewType: Int): ItemPostBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_post,
            parent,
            false
        )
    }

    override fun registerEvents(holder: BaseViewHolder<ItemPostBinding>) {
        super.registerEvents(holder)
        holder.binding.root.setOnClickListener {
            onItemClick()
        }
    }

    override fun bind(binding: ItemPostBinding, position: Int, item: MovieModel?) {
        binding.movie = item
    }
}