package com.dudencov.redditapp.domain.use_cases

import com.dudencov.redditapp.data.Repository
import com.dudencov.redditapp.data.remote.models.RequestModelTopList
import com.dudencov.redditapp.domain.entities.ModelTopList
import io.reactivex.Single
import javax.inject.Inject

class TopListInteractor @Inject constructor(private val repository: Repository) : TopListUseCases {

    override fun getTopModelData(model: RequestModelTopList): Single<List<ModelTopList>> {
        return repository.getTopModelData(model)
    }
}