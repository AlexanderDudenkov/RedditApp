package com.dudencov.redditapp.repository.remote

import com.dudencov.redditapp.repository.remote.models.Data
import io.reactivex.Single

interface RemoteRepo {
    fun getTopModelData(): Single<Data>
}