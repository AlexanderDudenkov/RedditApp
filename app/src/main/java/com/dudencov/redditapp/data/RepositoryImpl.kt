package com.dudencov.redditapp.data

import com.dudencov.redditapp.data.local.LocalRepo
import com.dudencov.redditapp.data.remote.RemoteRepo
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    override val localRepo: LocalRepo,
    override val remoteRepo: RemoteRepo
) : Repository