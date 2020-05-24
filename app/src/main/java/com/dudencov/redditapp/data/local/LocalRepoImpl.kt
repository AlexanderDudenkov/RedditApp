package com.dudencov.redditapp.data.local

import com.dudencov.redditapp.data.local.db.AppDatabase
import com.dudencov.redditapp.data.local.db.tables.TopListEntity
import io.reactivex.Single
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(val db: AppDatabase) : LocalRepo {

    override fun saveTopListEntities(list: List<TopListEntity>) {
        return db.getTopListDao().insertList(list)
    }

    override fun getTopListEntities(): Single<List<TopListEntity>> {
        return db.getTopListDao().getAll()
    }

    override fun deleteTopListEntities() {
        db.getTopListDao().deleteAll()
    }

    override fun update(list: List<TopListEntity>) {
        db.getTopListDao().update(list)
    }
}