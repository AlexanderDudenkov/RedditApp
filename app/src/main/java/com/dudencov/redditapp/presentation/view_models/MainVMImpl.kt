package com.dudencov.redditapp.presentation.view_models

import android.app.Application
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.domain.use_cases.TopListUseCases
import com.dudencov.redditapp.domain.utils.getTimeAgo
import com.dudencov.redditapp.presentation.dto.TopListUiModel
import com.dudencov.redditapp.presentation.utils.createConfig
import com.dudencov.redditapp.presentation.utils.createDataSourceFactory
import com.dudencov.redditapp.presentation.utils.map
import com.dudencov.redditapp.presentation.view.utils.recycler_view.RecyclerData
import com.dudencov.redditapp.presentation.view_models.utils.BaseViewModel
import com.dudencov.redditapp.presentation.view_models.utils.toRecyclerItem
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject

class MainVMImpl @Inject constructor(
    cxt: Application,
    private val topListUseCases: TopListUseCases
) : BaseViewModel(cxt), MainViewModel {

    override val liveViewModel: LiveData<PagedList<RecyclerData>> by lazy {
        LivePagedListBuilder(
            TopListDataSource().createDataSourceFactory<String, RecyclerData>(),
            createConfig()
        ).setFetchExecutor(Executors.newSingleThreadExecutor()).build()
    }

    var topListUiData: List<TopListUiModel> = emptyList()

    override val mainProgressBarVisibility: LiveData<Boolean> = MutableLiveData(false)

    inner class TopListDataSource : PageKeyedDataSource<String, RecyclerData>() {

        override fun loadInitial(
            params: LoadInitialParams<String>,
            callback: LoadInitialCallback<String, RecyclerData>
        ) {
            (mainProgressBarVisibility as MutableLiveData).postValue(true)
            loadTopModelData(
                RequestModelTopList(limit = 50),
                { uiList, key ->
                    mainProgressBarVisibility.postValue(false)
                    callback.onResult(uiList, null, key)
                },
                { rawList -> topListUiData = rawList.map { it.map { dateUtc -> Date(dateUtc).getTimeAgo() } }
                    rawList.map {toRecyclerItem()}
                }
            )
        }

        override fun loadAfter(
            params: LoadParams<String>,
            callback: LoadCallback<String, RecyclerData>
        ) {
            loadTopModelData(
                RequestModelTopList(itemName = params.key, limit = 10),
                { uiList, key -> callback.onResult(uiList, key) },
                { rawList ->
                    topListUiData = rawList.map { it.map { dateUtc -> Date(dateUtc).getTimeAgo() } }
                    rawList.map {toRecyclerItem()}
                }
            )
        }

        override fun loadBefore(
            params: LoadParams<String>,
            callback: LoadCallback<String, RecyclerData>
        ) {/*no op*/}
    }

    private fun loadTopModelData(
        requestModel: RequestModelTopList,
        resultCallback: (result: List<RecyclerData>, key: String?) -> Unit,
        mapperCallback: (from: List<ModelTopList>) -> List<RecyclerData>
    ) {
        var key: String? = null
        cd.add(
            topListUseCases.getTopModelData(requestModel)
                .map { rawList ->
                    key = rawList.last().itemName
                    mapperCallback(rawList)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { uiList ->
                        Log.d(javaClass.simpleName, uiList.toString())
                        resultCallback(uiList, key)
                    },
                    {
                        Log.d(javaClass.simpleName, it.message ?: "error")
                        Toast.makeText(getApplication(), it.message, Toast.LENGTH_LONG).show()
                        (mainProgressBarVisibility as MutableLiveData).value = false
                    }
                )
        )
    }

    fun handleClickOnItem(itemPos:Int) {
        openDetailScreen(topListUiData[itemPos].detailUrl)
    }

    private fun openDetailScreen(url: String?) {
        if (url.isNullOrEmpty()) {
            Toast.makeText(getApplication(), "Not possible to open page!", Toast.LENGTH_SHORT).show()
        } else {
            openBrowser(url)
        }
    }

    private fun openBrowser(url: String) {
        CustomTabsIntent.Builder().build().launchUrl(getApplication(), Uri.parse(url))
    }

}