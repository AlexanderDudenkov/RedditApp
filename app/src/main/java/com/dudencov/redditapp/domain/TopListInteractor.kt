package com.dudencov.redditapp.domain

import com.dudencov.redditapp.domain.entities.ModelTopList
import com.dudencov.redditapp.domain.mappers.DataAndModelTopListMapper
import com.dudencov.redditapp.data.Repository
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import io.reactivex.Single
import javax.inject.Inject

class TopListInteractor @Inject constructor(
    val repository: Repository,
    var dataModeltoplistMapper: DataAndModelTopListMapper
) : TopListUseCases {

    override fun getTopModelData(model: RequestModelTopList): Single<List<ModelTopList>> {
        return repository.remoteRepo.getTopModelData(model)
            .map { data -> dataModeltoplistMapper.mapDataToModelTopList(data) }
    }
}