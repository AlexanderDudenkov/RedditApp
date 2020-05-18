package com.dudencov.redditapp.di.modules

import android.content.Context
import com.dudencov.redditapp.di.scopes.FragmentScope
import com.dudencov.redditapp.presentation.view.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainFragmentModule(private val activity: MainActivity) {

    @Provides
    @FragmentScope
    fun provideFragmentModule(): Context = activity.baseContext

}