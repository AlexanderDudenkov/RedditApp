package com.dudencov.redditapp.presentation.view.utils.recycler_view

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

data class RecyclerData(val model: Any,
                        @LayoutRes val layoutId: Int,
                        val variableId: Int,
                        val variableItemPosId:Int) {

    fun bind(binding: ViewDataBinding, itemPos:Int) {
        binding.setVariable(variableId, model)
        binding.setVariable(variableItemPosId, itemPos)
    }
}