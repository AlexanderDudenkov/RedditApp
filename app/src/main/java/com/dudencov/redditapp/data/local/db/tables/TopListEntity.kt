package com.dudencov.redditapp.data.local.db.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TopListTable")
data class TopListEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "subreddit")
    val subreddit: String,

    @ColumnInfo(name = "postDateUtc")
    val postDateUtc: Long,

    @ColumnInfo(name = "thumbnailUrl")
    val thumbnailUrl: String,

    @ColumnInfo(name = "currentRating")
    val currentRating: Int,

    @ColumnInfo(name = "commentsNumber")
    val commentsNumber: Int,

    /**Using for pagination*/
    @ColumnInfo(name = "itemName")
    val itemName: String,

    @ColumnInfo(name = "detailUrl")
    val detailUrl: String
)

