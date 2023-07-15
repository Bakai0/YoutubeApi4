package com.example.youtubeapi.data.remote.apiservice

import com.example.youtubeapi.data.model.YoutubeResponse
import com.example.youtubeapi.data.model.video.VideoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApiService {

    @GET("videos")
    suspend fun fetchVideo(
        @Query("part") part: String = "snippet",
        @Query("regionCode") regionCode: String = "ru",
        @Query("chart") chart: String = "mostPopular",
        @Query("videoCategoryId") categoryId: String? = null
    ): Response<YoutubeResponse<VideoModel>>
}