package com.dudencov.redditapp.util

import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.PagedList

fun <K, T> ViewModel.createDataSourceFactory(dataSource: DataSource<K, T>): DataSource.Factory<K, T> {
    return object : DataSource.Factory<K, T>() {
        override fun create(): DataSource<K, T> {
            return dataSource
        }
    }
}

fun ViewModel.createConfig(
    initialLoadSizeHint: Int = 50,
    perPage: Int = 50,
    prefetchDistance: Int = 3
): PagedList.Config {

    return PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setInitialLoadSizeHint(initialLoadSizeHint)
        .setPrefetchDistance(prefetchDistance)
        .setPageSize(perPage).build()
}