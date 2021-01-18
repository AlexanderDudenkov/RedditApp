package com.dudencov.redditapp.di.components

import android.app.Application
import com.dudencov.redditapp.di.modules.ActivityModule
import com.dudencov.redditapp.di.modules.AppModule
import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.presentation.App
import com.dudencov.redditapp.presentation.view_models.MainVMImpl
import com.dudencov.redditapp.presentation.view_models.utils.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun mainViewModelFactory(): ViewModelFactory<MainVMImpl>
}