package com.dudencov.redditapp.presentation.utils

import androidx.paging.DataSource
import androidx.paging.PagedList

fun <K, T> DataSource<K, T>.createDataSourceFactory(): DataSource.Factory<K, T> =
    object : DataSource.Factory<K, T>() {
        override fun create(): DataSource<K, T> = this@createDataSourceFactory
    }

fun createConfig(
    initialLoadSizeHint: Int = 50,
    perPage: Int = 50,
    prefetchDistance: Int = 3
): PagedList.Config = PagedList.Config.Builder()
    .setEnablePlaceholders(true)
    .setInitialLoadSizeHint(initialLoadSizeHint)
    .setPrefetchDistance(prefetchDistance)
    .setPageSize(perPage).build()
