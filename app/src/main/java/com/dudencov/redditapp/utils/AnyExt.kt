package com.dudencov.redditapp.utils

import android.util.Log
import com.dudencov.redditapp.BuildConfig

val Any.TAG: String
    get() = javaClass.simpleName

fun Any.d(message: String) {
    if (BuildConfig.DEBUG) Log.d(TAG, message)
}
