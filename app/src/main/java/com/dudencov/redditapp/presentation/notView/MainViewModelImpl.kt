package com.dudencov.redditapp.presentation.notView

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.domain.TopListUseCases
import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.presentation.view.adapters.TopListUiModel
import com.dudencov.redditapp.util.createConfig
import com.dudencov.redditapp.util.createDataSourceFactory
import com.dudencov.redditapp.util.getTimeAgo
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject
import kotlin.collections.ArrayList

class MainViewModelImpl @Inject constructor(
    cxt: Application,
    private val topListUseCases: TopListUseCases
) : BaseViewModel(cxt), MainViewModel {

    override val topListUiLiveData: LiveData<PagedList<TopListUiModel>>? by lazy {
        LivePagedListBuilder(
            createDataSourceFactory<String, TopListUiModel>(TopListDataSource()),
            createConfig()
        ).setFetchExecutor(Executors.newSingleThreadExecutor()).build()
    }

    override val mainProgressBarVisibility: LiveData<Boolean> = MutableLiveData(false)

    inner class TopListDataSource : PageKeyedDataSource<String, TopListUiModel>() {
        override fun loadInitial(
            params: LoadInitialParams<String>,
            callback: LoadInitialCallback<String, TopListUiModel>
        ) {
            (mainProgressBarVisibility as MutableLiveData).postValue(true)
            loadTopModelData(
                RequestModelTopList(limit = 50),
                { uiList, key ->
                    mainProgressBarVisibility.postValue(false)
                    callback.onResult(uiList, null, key)
                },
                { rawList ->
                    mapToTopListUiModel(rawList) { dateUtc ->
                        Date(dateUtc).getTimeAgo()
                    }
                }
            )
        }

        override fun loadAfter(
            params: LoadParams<String>,
            callback: LoadCallback<String, TopListUiModel>
        ) {
            loadTopModelData(
                RequestModelTopList(itemName = params.key, limit = 10),
                { uiList, key -> callback.onResult(uiList, key) },
                { rawList ->
                    mapToTopListUiModel(rawList) { dateUtc ->
                        Date(dateUtc).getTimeAgo()
                    }
                }
            )
        }

        override fun loadBefore(
            params: LoadParams<String>,
            callback: LoadCallback<String, TopListUiModel>
        ) {
        }
    }

    private fun loadTopModelData(
        requestModel: RequestModelTopList,
        resultCallback: (result: List<TopListUiModel>, key: String?) -> Unit,
        mapperCallback: (from: List<ModelTopList>) -> List<TopListUiModel>
    ) {
        var key: String? = null
        cd.add(
            topListUseCases.getTopModelData(requestModel)
                .map { rawList ->
                    key = rawList.last().itemName
                    mapperCallback(rawList)
                }
                .subscribe(
                    { uiList ->
                        Log.d(javaClass.simpleName, uiList.toString())
                        resultCallback(uiList, key)
                    },
                    { Log.d(javaClass.simpleName, it.message ?: "error") }
                )
        )
    }

    private fun mapToTopListUiModel(
        from: List<ModelTopList>,
        postDateCallback: (postDate: Long) -> String
    ): List<TopListUiModel> {

        val result: ArrayList<TopListUiModel> = ArrayList()

        from.forEach {
            result.add(
                TopListUiModel(
                    title = it.title,
                    author = "Posted by ${it.author}",
                    subreddit = it.subreddit,
                    postDate = postDateCallback(it.postDateUtc),
                    thumbnailUrl = it.thumbnailUrl,
                    currentRating = it.currentRating.toString(),
                    commentsNumber = "${it.commentsNumber} Comments",
                    detailUrl = it.detailUrl
                )
            )
        }
        return result
    }
}