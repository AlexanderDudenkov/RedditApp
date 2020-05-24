package com.dudencov.redditapp.data.local.db.dao

import androidx.room.*
import com.dudencov.redditapp.data.local.db.tables.TopListEntity
import io.reactivex.Single

@Dao
interface TopListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<TopListEntity>)

    @Query("SELECT * FROM TopListTable")
    fun getAll(): Single<List<TopListEntity>>

    @Query("DELETE FROM TopListTable")
    fun deleteAll()

    @Update
    fun update(list: List<TopListEntity>)
}