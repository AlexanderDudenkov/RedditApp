package com.dudencov.redditapp.presentation.view.utils.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RecyclerPagedAdapter(diffCallback: DiffUtil.ItemCallback<RecyclerData>) :
    PagedListAdapter<RecyclerData, BindingViewHolder>(diffCallback) {

    override fun getItemViewType(position: Int): Int = getItem(position)?.layoutId ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        getItem(position)?.bind(holder.binding, position)
        holder.binding.executePendingBindings()
    }
}

@BindingAdapter("paged_items")
fun setRecyclerPagedItems(recyclerView: RecyclerView, data: PagedList<RecyclerData>?) {
    var adapter = (recyclerView.adapter as? RecyclerPagedAdapter)
    if (adapter == null) {
        adapter = RecyclerPagedAdapter(ItemDiffCallback())
        recyclerView.adapter = adapter
    }
    adapter.submitList(data)
}