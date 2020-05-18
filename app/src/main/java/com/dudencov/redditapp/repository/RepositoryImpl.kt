package com.dudencov.redditapp.repository

import com.dudencov.redditapp.repository.local.LocalRepo
import com.dudencov.redditapp.repository.remote.RemoteRepo
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    override val localRepo: LocalRepo,
    override val remoteRepo: RemoteRepo
) : Repository