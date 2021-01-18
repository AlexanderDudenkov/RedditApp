package com.dudencov.redditapp.domain.entities

data class ModelTopList(
    val title: String,
    val author: String,
    val subreddit: String,
    val postDateUtc: Long,
    val thumbnailUrl: String,
    val currentRating: Int,
    val commentsNumber: Int,

    /**Using for pagination*/
    val itemName: String,
    val detailUrl: String
)