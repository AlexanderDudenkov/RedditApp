package com.dudencov.redditapp.di.components

import android.app.Activity

interface DaggerComponentProvider {
    val component: AppComponent
}

val Activity.injector get() = (application as DaggerComponentProvider).component