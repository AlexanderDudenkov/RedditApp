package com.dudencov.redditapp.domain.mappers

import com.dudencov.redditapp.data.remote.models.Data
import com.dudencov.redditapp.domain.entities.ModelTopList

interface ServerDomainMapper {
    fun mapDataToModelTopList(from: Data): List<ModelTopList>

}