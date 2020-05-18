package com.dudencov.redditapp.repository.remote

import com.dudencov.redditapp.repository.remote.models.Data
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(val redditApi: RedditApi) : RemoteRepo {

    override fun getTopModelData(): Single<Data> {
        return redditApi.getTops()
            .subscribeOn(Schedulers.io())
            .map { topModel -> topModel.data }
    }
}