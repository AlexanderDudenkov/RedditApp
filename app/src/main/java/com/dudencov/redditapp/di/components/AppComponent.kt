package com.dudencov.redditapp.di.components

import android.content.Context
import com.dudencov.redditapp.di.modules.AppModule
import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.presentation.notView.MainViewModelImpl
import com.dudencov.redditapp.presentation.notView.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun build(): AppComponent
    }

    fun mainViewModelFactory(): ViewModelFactory<MainViewModelImpl>
}