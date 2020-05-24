package com.dudencov.redditapp.data.remote

import com.dudencov.redditapp.data.remote.models.TopModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    /**See detail API: https://www.reddit.com/dev/api/#GET_top*/
    @GET("top.json")
    fun getTops(
        @Query("after") itemName: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("count") count: Int? = null,
        @Query("show") show: String? = null
    ): Single<TopModel>
}