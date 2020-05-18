package com.dudencov.redditapp.domain.mappers

import com.dudencov.redditapp.data.ModelTopList
import com.dudencov.redditapp.repository.remote.models.Data

interface DataAndModelTopListMapper {
    fun mapDataToModelTopList(from: Data): List<ModelTopList>
}