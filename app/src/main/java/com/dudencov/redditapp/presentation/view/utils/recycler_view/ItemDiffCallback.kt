package com.dudencov.redditapp.presentation.view.utils.recycler_view

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}