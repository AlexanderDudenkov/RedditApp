package com.dudencov.redditapp.di.modules

import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.domain.mappers.DataAndModelTopListMapper
import com.dudencov.redditapp.domain.mappers.DataAndModelTopListMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    @ApplicationScope
    fun provideDataAndModelTopListMapper(): DataAndModelTopListMapper =
        DataAndModelTopListMapperImpl()
}