package com.dudencov.redditapp.data.local

import com.dudencov.redditapp.data.local.db.tables.TopListEntity
import io.reactivex.Single

interface LocalRepo {
    fun saveTopListEntities(list: List<TopListEntity>)
    fun getTopListEntities(): Single<List<TopListEntity>>
    fun deleteTopListEntities()
    fun update(list: List<TopListEntity>)
}