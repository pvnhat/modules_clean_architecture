package com.example.clear_architecture_base.ui.screens.postlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.clear_architecture_base.ui.base.recyclerview.BasePagingAdapter
import com.example.clear_architecture_base.ui.base.recyclerview.BaseViewHolder
import com.example.core.R
import com.example.core.databinding.ItemPostBinding
import com.example.domain.entities.PostModel

class PostsAdapter(private val onItemClick: () -> Unit) :
    BasePagingAdapter<PostModel, ItemPostBinding>() {
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

    override fun bind(binding: ItemPostBinding, position: Int, item: PostModel?) {
        binding.post = item
    }
}