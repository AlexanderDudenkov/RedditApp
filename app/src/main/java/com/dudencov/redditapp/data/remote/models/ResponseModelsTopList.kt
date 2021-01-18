package com.dudencov.redditapp.data.remote.models

import com.google.gson.annotations.SerializedName

data class TopModel(
    @SerializedName("data")
    val data: Data
)

data class Data(
    @SerializedName("children")
    val children: ArrayList<Child>
)

data class Child(
    @SerializedName("data")
    val childData: ChildData
)

data class ChildData(
    @SerializedName("subreddit")
    val subreddit: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("score")
    val score: Int,

    @SerializedName("num_comments")
    val numComments: Int,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("created_utc")
    val createdUtc: Long,

    @SerializedName("name")
    val itemName: String,

    @SerializedName("url")
    val detailUrl: String
)


