package com.dudencov.redditapp.presentation

import com.dudencov.redditapp.di.components.AppComponent
import com.dudencov.redditapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private val appInjector: AppComponent =
        DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun androidInjector(): AndroidInjector<Any> =
        AndroidInjector {
            return@AndroidInjector androidInjector.inject(it)
        }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        appInjector

    companion object {
        private var instance: App? = null
        @JvmStatic
        fun get(): App = instance!!

        @JvmStatic
        fun getAppComponent(): AppComponent {
            return get().appInjector
        }
    }
}