package com.dudencov.redditapp.di.modules

import android.app.Application
import com.dudencov.redditapp.di.scopes.ApplicationScope
import com.dudencov.redditapp.domain.TopListInteractor
import com.dudencov.redditapp.domain.TopListUseCases
import com.dudencov.redditapp.domain.mappers.DataAndModelTopListMapper
import com.dudencov.redditapp.presentation.App
import com.dudencov.redditapp.repository.Repository
import com.dudencov.redditapp.repository.RepositoryImpl
import com.dudencov.redditapp.repository.local.LocalRepo
import com.dudencov.redditapp.repository.local.LocalRepoImpl
import com.dudencov.redditapp.repository.remote.RedditApi
import com.dudencov.redditapp.repository.remote.RemoteRepo
import com.dudencov.redditapp.repository.remote.RemoteRepoImpl
import dagger.Module
import dagger.Provides

@Module(includes = [NetModule::class, MapperModule::class])
class AppModule {

    @Provides
    @ApplicationScope
    fun provideApplication(): Application = App.instance

    @Provides
    @ApplicationScope
    fun provideTopListUseCases(
        repository: Repository,
        mapper: DataAndModelTopListMapper
    ): TopListUseCases = TopListInteractor(repository, mapper)

    @Provides
    @ApplicationScope
    fun provideRepository(local: LocalRepo, remote: RemoteRepo): Repository =
        RepositoryImpl(local, remote)

    @Provides
    @ApplicationScope
    fun provideLocalRepo(): LocalRepo = LocalRepoImpl()

    @Provides
    @ApplicationScope
    fun provideRemoteRepo(apiService: RedditApi): RemoteRepo = RemoteRepoImpl(apiService)
}