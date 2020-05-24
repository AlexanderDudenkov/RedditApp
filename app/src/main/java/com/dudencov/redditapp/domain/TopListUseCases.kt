package com.dudencov.redditapp.domain

import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.domain.entities.ModelTopList
import io.reactivex.Single

interface TopListUseCases {
    fun getTopModelData(model: RequestModelTopList): Single<List<ModelTopList>>
}