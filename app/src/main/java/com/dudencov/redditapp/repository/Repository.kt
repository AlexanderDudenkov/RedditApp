package com.dudencov.redditapp.repository

import com.dudencov.redditapp.repository.local.LocalRepo
import com.dudencov.redditapp.repository.remote.RemoteRepo

interface Repository {
    val localRepo: LocalRepo
    val remoteRepo: RemoteRepo
}