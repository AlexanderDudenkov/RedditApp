package com.dudencov.redditapp.di.components

import com.dudencov.redditapp.di.modules.MainFragmentModule
import com.dudencov.redditapp.di.scopes.FragmentScope
import com.dudencov.redditapp.presentation.view.MainFragment
import dagger.Component

@FragmentScope
@Component(modules = [MainFragmentModule::class], dependencies = [AppComponent::class])
interface MainFragmentComponent {
    fun inject(mainFragment: MainFragment)
}