package com.dudencov.redditapp.di.modules

import com.dudencov.redditapp.di.scopes.FragmentScope
import com.dudencov.redditapp.presentation.view.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeMainFragment(): MainFragment
}