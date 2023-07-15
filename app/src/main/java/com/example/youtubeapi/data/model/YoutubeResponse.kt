package com.example.youtubeapi.data.model

import com.google.gson.annotations.SerializedName

data class YoutubeResponse<T>(

    @SerializedName("kind")
    val kind : String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("items")
    val items: List<T>
)
