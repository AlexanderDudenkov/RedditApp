package com.dudencov.redditapp.di.modules

import com.dudencov.redditapp.data.Repository
import com.dudencov.redditapp.data.RepositoryImpl
import com.dudencov.redditapp.data.local.LocalRepo
import com.dudencov.redditapp.data.local.LocalRepoImpl
import com.dudencov.redditapp.data.local.db.AppDatabase
import com.dudencov.redditapp.data.remote.RedditApi
import com.dudencov.redditapp.data.remote.RemoteRepo
import com.dudencov.redditapp.data.remote.RemoteRepoImpl
import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.domain.use_cases.TopListInteractor
import com.dudencov.redditapp.domain.use_cases.TopListUseCases
import dagger.Module
import dagger.Provides

@Module(includes = [NetModule::class, RoomModule::class])
class AppModule {

    @Provides
    @ApplicationScope
    fun provideTopListUseCases(
        repository: Repository
    ): TopListUseCases = TopListInteractor(repository)

    @Provides
    @ApplicationScope
    fun provideRepository(local: LocalRepo, remote: RemoteRepo): Repository = RepositoryImpl(local, remote)

    @Provides
    @ApplicationScope
    fun provideLocalRepo(db: AppDatabase): LocalRepo = LocalRepoImpl(db)

    @Provides
    @ApplicationScope
    fun provideRemoteRepo(apiService: RedditApi): RemoteRepo = RemoteRepoImpl(apiService)
}