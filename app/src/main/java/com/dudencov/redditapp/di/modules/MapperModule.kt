package com.dudencov.redditapp.di.modules

import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.domain.mappers.DbDomainMapper
import com.dudencov.redditapp.domain.mappers.DbDomainMapperImpl
import com.dudencov.redditapp.domain.mappers.ServerDomainMapper
import com.dudencov.redditapp.domain.mappers.ServerDomainMapperImpl
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    @ApplicationScope
    fun provideServerDomainMapper(): ServerDomainMapper = ServerDomainMapperImpl()

    @Provides
    @ApplicationScope
    fun provideDbDomainMapper(): DbDomainMapper = DbDomainMapperImpl()
}