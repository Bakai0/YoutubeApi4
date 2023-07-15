package com.example.youtubeapi.data.repository

import com.example.youtubeapi.base.BaseRepository
import com.example.youtubeapi.data.remote.apiservice.VideoApiService
import javax.inject.Inject

class VideoRepository  @Inject constructor(private val service: VideoApiService) : BaseRepository() {

    fun fetchVideo(categoryId: String?) = doRequest {
        service.fetchVideo(categoryId = categoryId)
    }
}