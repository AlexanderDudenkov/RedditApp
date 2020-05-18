package com.dudencov.redditapp.presentation.notView

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dudencov.redditapp.data.ModelTopList
import com.dudencov.redditapp.domain.TopListUseCases
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class MainViewModelImpl @Inject constructor(
    cxt: Application,
    val topListUseCases: TopListUseCases
) : BaseViewModel(cxt), MainViewModel {

    override var topListLiveData: LiveData<List<ModelTopList>> = MutableLiveData()

    init {
        cd.add(
            topListUseCases.getTopModelData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(javaClass.simpleName, it.toString())
                    (topListLiveData as MutableLiveData).value = it
                },
                    { Log.d(javaClass.simpleName, it.message ?: "error") })
        )
    }
}