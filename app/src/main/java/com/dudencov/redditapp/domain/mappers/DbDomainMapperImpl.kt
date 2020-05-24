package com.dudencov.redditapp.domain.mappers

import com.dudencov.redditapp.data.local.db.tables.TopListEntity
import com.dudencov.redditapp.domain.entities.ModelTopList

class DbDomainMapperImpl : DbDomainMapper {
    override fun mapModelTopListToTopListEntity(from: List<ModelTopList>): List<TopListEntity> {
        return ArrayList<TopListEntity>().apply {
            from.forEach {
                add(
                    TopListEntity(
                        title = it.title,
                        author = it.author,
                        subreddit = it.subreddit,
                        postDateUtc = it.postDateUtc,
                        thumbnailUrl = it.thumbnailUrl,
                        currentRating = it.currentRating,
                        commentsNumber = it.commentsNumber,
                        itemName = it.itemName,
                        detailUrl = it.detailUrl
                    )
                )
            }
        }
    }

    override fun mapTopListEntityToModelTopList(from: List<TopListEntity>): List<ModelTopList> {
        return ArrayList<ModelTopList>().apply {
            from.forEach {
                add(
                    ModelTopList(
                        title = it.title,
                        author = it.author,
                        subreddit = it.subreddit,
                        postDateUtc = it.postDateUtc,
                        thumbnailUrl = it.thumbnailUrl,
                        currentRating = it.currentRating,
                        commentsNumber = it.commentsNumber,
                        itemName = it.itemName,
                        detailUrl = it.detailUrl
                    )
                )
            }
        }
    }
}