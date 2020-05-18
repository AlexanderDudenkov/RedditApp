package com.dudencov.redditapp.data

data class ModelTopList(
    val title: String,
    val author: String,
    val subreddit: String,
    val postDateUtc: Long,
    val thumbnailUrl: String,
    val currentRating: Int,
    val commentsNumber: Int
)