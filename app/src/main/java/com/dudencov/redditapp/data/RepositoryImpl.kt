package com.dudencov.redditapp.data

import com.dudencov.redditapp.data.local.LocalRepo
import com.dudencov.redditapp.data.remote.RemoteRepo
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.data.utils.map
import com.dudencov.redditapp.domain.entities.ModelTopList
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    var localRepo: LocalRepo, var remoteRepo: RemoteRepo
) : Repository {

    override fun getTopModelData(model: RequestModelTopList): Single<List<ModelTopList>> {
        return remoteRepo.getTopModelData(model)
            .map { data -> data.children.map { it.childData.map() } }
            .doOnSuccess { fromServer ->
                if (!fromServer.isNullOrEmpty()) {
                    localRepo.deleteTopListEntities()
                    localRepo.saveTopListEntities(fromServer.map { it.map() })
                }
            }
            .onErrorResumeNext {
                localRepo.getTopListEntities().map { fromDb -> fromDb.map { it.map() } }
            }
    }
}