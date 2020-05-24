package com.dudencov.redditapp.domain.mappers

import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.data.remote.models.Data

class DataAndModelTopListMapperImpl : DataAndModelTopListMapper {

    override fun mapDataToModelTopList(from: Data): List<ModelTopList> {
        val result: ArrayList<ModelTopList> = ArrayList()

        from.children.forEach {
            result.add(
                ModelTopList(
                    title = it.childData.title,
                    author = it.childData.author,
                    subreddit = it.childData.subreddit,
                    postDateUtc = it.childData.created_utc,
                    thumbnailUrl = it.childData.thumbnail,
                    currentRating = it.childData.score,
                    commentsNumber = it.childData.num_comments,
                    itemName = it.childData.itemName,
                    detailUrl = it.childData.detailUrl
                )
            )
        }
        return result
    }
}