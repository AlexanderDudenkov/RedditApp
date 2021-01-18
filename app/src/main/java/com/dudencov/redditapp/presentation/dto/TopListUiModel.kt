package com.dudencov.redditapp.presentation.dto

data class TopListUiModel(
    val title: String,
    val author: String,
    val subreddit: String,
    val postDate: String,
    val thumbnailUrl: String,
    val currentRating: String,
    val commentsNumber: String,
    val detailUrl: String
)