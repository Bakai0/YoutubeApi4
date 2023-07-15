package com.example.youtubeapi.data.model.video

import com.google.gson.annotations.SerializedName

data class VideoModel(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("snippet")
    val snippet: VideoSnippet
)
