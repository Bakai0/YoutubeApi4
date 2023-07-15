package com.example.youtubeapi.di

import com.example.youtubeapi.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideCategoryApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideCategoryApiService()

    @Singleton
    @Provides
    fun provideVideoApiService(retrofitClient: RetrofitClient) =
        retrofitClient.provideVideoApiService()
}