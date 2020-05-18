package com.dudencov.redditapp.repository.remote

import com.dudencov.redditapp.util.Constants
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object OkhttpTool {

    private fun createOkHttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
        }
        val okHttpClient = OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            networkInterceptors().add(logInterceptor)
        }
        return okHttpClient.build()
    }

    fun createHttpConnection(): RedditApi {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(createOkHttpClient())
            .build()

        return retrofit.create(RedditApi::class.java)
    }
}