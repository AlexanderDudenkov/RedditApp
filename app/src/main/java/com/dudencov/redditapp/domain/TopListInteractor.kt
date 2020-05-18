package com.dudencov.redditapp.domain

import com.dudencov.redditapp.data.ModelTopList
import com.dudencov.redditapp.domain.mappers.DataAndModelTopListMapper
import com.dudencov.redditapp.repository.Repository
import io.reactivex.Single

class TopListInteractor(
    val repository: Repository,
    var dataModeltoplistMapper: DataAndModelTopListMapper
) : TopListUseCases {

    override fun getTopModelData(): Single<List<ModelTopList>> {
        return repository.remoteRepo.getTopModelData()
            .map { data -> dataModeltoplistMapper.mapDataToModelTopList(data) }
    }
}