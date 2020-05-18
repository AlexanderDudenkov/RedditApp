package com.dudencov.redditapp.repository

import com.dudencov.redditapp.repository.local.LocalRepo
import com.dudencov.redditapp.repository.local.LocalRepoImpl
import com.dudencov.redditapp.repository.remote.OkhttpTool
import com.dudencov.redditapp.repository.remote.RemoteRepo
import com.dudencov.redditapp.repository.remote.RemoteRepoImpl

class RepositoryImpl() : Repository {
    override var localRepo: LocalRepo = LocalRepoImpl()
    override var remoteRepo: RemoteRepo = RemoteRepoImpl(OkhttpTool)
}