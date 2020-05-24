package com.dudencov.redditapp.di.modules

import android.app.Application
import com.dudencov.redditapp.data.Repository
import com.dudencov.redditapp.data.RepositoryImpl
import com.dudencov.redditapp.data.local.LocalRepo
import com.dudencov.redditapp.data.local.LocalRepoImpl
import com.dudencov.redditapp.data.local.db.AppDatabase
import com.dudencov.redditapp.data.remote.RedditApi
import com.dudencov.redditapp.data.remote.RemoteRepo
import com.dudencov.redditapp.data.remote.RemoteRepoImpl
import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.domain.TopListInteractor
import com.dudencov.redditapp.domain.TopListUseCases
import com.dudencov.redditapp.domain.mappers.DbDomainMapper
import com.dudencov.redditapp.domain.mappers.ServerDomainMapper
import com.dudencov.redditapp.presentation.App
import dagger.Module
import dagger.Provides

@Module(includes = [NetModule::class, MapperModule::class, RoomModule::class])
class AppModule {

    @Provides
    @ApplicationScope
    fun provideApplication(): Application = App.instance

    @Provides
    @ApplicationScope
    fun provideTopListUseCases(
        repository: Repository
    ): TopListUseCases = TopListInteractor(repository)

    @Provides
    @ApplicationScope
    fun provideRepository(
        local: LocalRepo,
        remote: RemoteRepo,
        serverDomainMapper: ServerDomainMapper,
        dbDomainMapper: DbDomainMapper
    ): Repository = RepositoryImpl(local, remote, serverDomainMapper, dbDomainMapper)

    @Provides
    @ApplicationScope
    fun provideLocalRepo(db: AppDatabase): LocalRepo = LocalRepoImpl(db)

    @Provides
    @ApplicationScope
    fun provideRemoteRepo(apiService: RedditApi): RemoteRepo = RemoteRepoImpl(apiService)
}