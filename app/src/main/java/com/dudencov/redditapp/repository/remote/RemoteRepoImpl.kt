package com.dudencov.redditapp.repository.remote

import com.dudencov.redditapp.repository.remote.models.Data
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class RemoteRepoImpl(val okhttpTool: OkhttpTool) : RemoteRepo {

    override fun getTopModelData(): Single<Data> {
        return okhttpTool.createHttpConnection().getTops()
            .subscribeOn(Schedulers.io())
            .map { topModel -> topModel.data }
    }
}