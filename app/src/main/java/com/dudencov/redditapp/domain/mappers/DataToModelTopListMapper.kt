package com.dudencov.redditapp.domain.mappers

import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.data.remote.models.Data

interface DataAndModelTopListMapper {
    fun mapDataToModelTopList(from: Data): List<ModelTopList>
}