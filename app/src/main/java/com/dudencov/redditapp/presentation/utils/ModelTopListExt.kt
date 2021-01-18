package com.dudencov.redditapp.presentation.utils

import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.presentation.dto.TopListUiModel

fun ModelTopList.map(postDateCallback: (postDate: Long) -> String) = TopListUiModel(
    title = title,
    author = "Posted by $author",
    subreddit = subreddit,
    postDate = postDateCallback(postDateUtc),
    thumbnailUrl = thumbnailUrl,
    currentRating = currentRating.toString(),
    commentsNumber = "$commentsNumber Comments",
    detailUrl = detailUrl
)