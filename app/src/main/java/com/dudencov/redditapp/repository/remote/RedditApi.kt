package com.dudencov.redditapp.repository.remote

import com.dudencov.redditapp.repository.remote.models.TopModel
import io.reactivex.Single
import retrofit2.http.GET

interface RedditApi {

    @GET("top.json")
    fun getTops(): Single<TopModel>
}