package com.example.youtubeapi.data.repository

import com.example.youtubeapi.base.BaseRepository
import com.example.youtubeapi.data.remote.apiservice.VideoCategoryApiService
import javax.inject.Inject

class VideoCategoryRepository  @Inject constructor(private val service: VideoCategoryApiService) :
    BaseRepository() {

    fun fetchVideoCategory() = doRequest {
        service.fetchVideoCategory()
    }
}