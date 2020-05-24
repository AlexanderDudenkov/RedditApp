package com.dudencov.redditapp.domain.mappers

import com.dudencov.redditapp.data.local.db.tables.TopListEntity
import com.dudencov.redditapp.domain.entities.ModelTopList

interface DbDomainMapper {
    fun mapModelTopListToTopListEntity(from: List<ModelTopList>): List<TopListEntity>
    fun mapTopListEntityToModelTopList(from: List<TopListEntity>): List<ModelTopList>
}