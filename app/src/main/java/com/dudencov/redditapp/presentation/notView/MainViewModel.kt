package com.dudencov.redditapp.presentation.notView

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dudencov.redditapp.presentation.view.adapters.TopListUiModel

interface MainViewModel {
    val topListUiLiveData: LiveData<PagedList<TopListUiModel>>?
    val mainProgressBarVisibility: LiveData<Boolean>
}