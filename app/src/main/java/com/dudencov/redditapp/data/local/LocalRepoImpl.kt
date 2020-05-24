package com.dudencov.redditapp.data.local

import com.dudencov.redditapp.data.local.db.AppDatabase
import javax.inject.Inject

class LocalRepoImpl @Inject constructor(val db: AppDatabase) : LocalRepo