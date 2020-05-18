package com.dudencov.redditapp.domain

import com.dudencov.redditapp.data.ModelTopList
import io.reactivex.Single

interface TopListUseCases {
    fun getTopModelData(): Single<List<ModelTopList>>
}