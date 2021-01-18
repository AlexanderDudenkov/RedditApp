package com.dudencov.redditapp.data.utils

import com.dudencov.redditapp.data.local.db.tables.TopListEntity
import com.dudencov.redditapp.domain.entities.ModelTopList

fun TopListEntity.map() = ModelTopList(
    title = title,
    author = author,
    subreddit = subreddit,
    postDateUtc = postDateUtc,
    thumbnailUrl = thumbnailUrl,
    currentRating = currentRating,
    commentsNumber = commentsNumber,
    itemName = itemName,
    detailUrl = detailUrl
)