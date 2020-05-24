package com.dudencov.redditapp.data

import com.dudencov.redditapp.data.local.LocalRepo
import com.dudencov.redditapp.data.remote.RemoteRepo

interface Repository {
    val localRepo: LocalRepo
    val remoteRepo: RemoteRepo
}