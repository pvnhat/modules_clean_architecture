package com.example.clear_architecture_base.ui.base.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<out VB : ViewDataBinding>(val binding: VB) :
    RecyclerView.ViewHolder(binding.root)
