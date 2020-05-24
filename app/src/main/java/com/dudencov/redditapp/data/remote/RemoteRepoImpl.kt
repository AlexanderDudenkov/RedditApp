package com.dudencov.redditapp.data.remote

import com.dudencov.redditapp.data.remote.models.Data
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(val redditApi: RedditApi) : RemoteRepo {

    override fun getTopModelData(model: RequestModelTopList): Single<Data> {
        return model.run {
            redditApi.getTops(itemName, limit, count, show)
                .subscribeOn(Schedulers.io())
                .map { topModel -> topModel.data }
        }
    }
}