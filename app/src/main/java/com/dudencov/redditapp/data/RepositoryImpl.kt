package com.dudencov.redditapp.data

import com.dudencov.redditapp.data.local.LocalRepo
import com.dudencov.redditapp.data.remote.RemoteRepo
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.domain.mappers.DbDomainMapper
import com.dudencov.redditapp.domain.mappers.ServerDomainMapper
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    var localRepo: LocalRepo,
    var remoteRepo: RemoteRepo,
    var serverDomainMapper: ServerDomainMapper,
    var dbDomainMapper: DbDomainMapper
) : Repository {

    override fun getTopModelData(model: RequestModelTopList): Single<List<ModelTopList>> {
        return remoteRepo.getTopModelData(model)
            .map { data -> serverDomainMapper.mapDataToModelTopList(data) }
            .doOnSuccess { fromServer ->
                if (!fromServer.isNullOrEmpty()) {
                    localRepo.deleteTopListEntities()
                    localRepo.saveTopListEntities(
                        dbDomainMapper.mapModelTopListToTopListEntity(fromServer)
                    )
                }
            }
            .onErrorResumeNext {
                localRepo.getTopListEntities()
                    .map { fromDb -> dbDomainMapper.mapTopListEntityToModelTopList(fromDb) }
            }
    }
}