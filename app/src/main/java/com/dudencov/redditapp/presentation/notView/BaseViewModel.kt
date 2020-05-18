package com.dudencov.redditapp.presentation.notView

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(cxt: Application) : AndroidViewModel(cxt) {

    val cd = CompositeDisposable()

    override fun onCleared() {
        cd.clear()
    }
}