package com.dudencov.redditapp.presentation.view.utils.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<BindingViewHolder>() {

    private val items = mutableListOf<RecyclerData>()

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = getRecyclerItem(position).layoutId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        getRecyclerItem(position).bind(holder.binding,position)
        holder.binding.executePendingBindings()
    }

    fun updateData(newData: List<RecyclerData>) {
        this.items.clear()
        this.items.addAll(newData)
        notifyDataSetChanged()
    }

    private fun getRecyclerItem(position: Int): RecyclerData = items[position]
}

@BindingAdapter("items")
fun setRecyclerViewItems(recyclerView: RecyclerView, data: List<RecyclerData>?) {
    var adapter = (recyclerView.adapter as? RecyclerViewAdapter)
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
    }

    adapter.updateData(data.orEmpty())
}