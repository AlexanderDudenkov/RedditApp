package com.dudencov.redditapp.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dudencov.redditapp.presentation.view.utils.recycler_view.RecyclerData

interface MainViewModel {
    val liveViewModel: LiveData<PagedList<RecyclerData>>?
    val mainProgressBarVisibility: LiveData<Boolean>
}