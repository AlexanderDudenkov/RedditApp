package com.dudencov.redditapp.presentation.notView

import androidx.lifecycle.LiveData
import com.dudencov.redditapp.data.ModelTopList

interface MainViewModel {
    var topListLiveData: LiveData<List<ModelTopList>>
}