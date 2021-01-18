package com.dudencov.redditapp.data.utils

import com.dudencov.redditapp.data.remote.models.ChildData
import com.dudencov.redditapp.domain.entities.ModelTopList

fun ChildData.map(): ModelTopList = ModelTopList(
    title = title,
    author = author,
    subreddit = subreddit,
    postDateUtc = createdUtc,
    thumbnailUrl = thumbnail,
    currentRating = score,
    commentsNumber = numComments,
    itemName = itemName,
    detailUrl = detailUrl
)