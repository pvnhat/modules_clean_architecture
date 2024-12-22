package com.example.clear_architecture_base.ui.base.recyclerview

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter

abstract class BasePagingAdapter<T : Any, VB : ViewDataBinding>(
    diffCallback: BaseDiffUtil<T> = BaseDiffUtil()
) : PagingDataAdapter<T, BaseViewHolder<VB>>(diffCallback) {

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val binding = createBinding(parent, viewType)
        val holder = BaseViewHolder(binding)
        registerEvents(holder)
        return holder
    }

    final override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        val item = getItem(position)
        holder.binding.run {
            bind(this, position, item)
            executePendingBindings()
        }
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): VB
    protected abstract fun bind(binding: VB, position: Int, item: T?)
    protected open fun registerEvents(holder: BaseViewHolder<VB>) {}
}
