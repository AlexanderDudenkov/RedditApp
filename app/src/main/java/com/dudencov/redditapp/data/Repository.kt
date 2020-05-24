package com.dudencov.redditapp.data

import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.domain.entities.ModelTopList
import io.reactivex.Single

interface Repository {
    fun getTopModelData(model: RequestModelTopList): Single<List<ModelTopList>>
}