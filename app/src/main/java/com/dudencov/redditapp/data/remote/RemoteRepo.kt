package com.dudencov.redditapp.data.remote

import com.dudencov.redditapp.data.remote.models.Data
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import io.reactivex.Single

interface RemoteRepo {
    fun getTopModelData(model: RequestModelTopList): Single<Data>
}