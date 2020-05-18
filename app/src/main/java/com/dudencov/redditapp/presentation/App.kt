package com.dudencov.redditapp.presentation

import androidx.multidex.MultiDexApplication
import com.dudencov.redditapp.di.components.AppComponent
import com.dudencov.redditapp.di.components.DaggerAppComponent
import com.dudencov.redditapp.di.components.DaggerComponentProvider

class App : MultiDexApplication(), DaggerComponentProvider {

    override val component: AppComponent by lazy {
        DaggerAppComponent.builder().applicationContext(applicationContext).build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}