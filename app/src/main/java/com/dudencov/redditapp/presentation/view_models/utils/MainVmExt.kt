package com.dudencov.redditapp.presentation.view_models.utils

import com.dudencov.redditapp.BR
import com.dudencov.redditapp.R
import com.dudencov.redditapp.presentation.view.utils.recycler_view.RecyclerData
import com.dudencov.redditapp.presentation.view_models.MainVMImpl

fun MainVMImpl.toRecyclerItem(): RecyclerData = RecyclerData(
    model = this,
    variableId = BR.mainVM,
    layoutId = R.layout.item_view,
    variableItemPosId = BR.itemPos
)