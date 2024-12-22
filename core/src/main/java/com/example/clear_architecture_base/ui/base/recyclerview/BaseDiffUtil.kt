package com.example.clear_architecture_base.ui.base.recyclerview

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtil<T> : DiffUtil.ItemCallback<T>() {


    override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        // Override this if your item have an id
        return true
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return oldItem == newItem
    }
}
