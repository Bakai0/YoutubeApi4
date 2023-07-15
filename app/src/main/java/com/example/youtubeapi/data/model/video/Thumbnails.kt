package com.example.youtubeapi.data.model.video

import com.google.gson.annotations.SerializedName

data class Thumbnails(
    @SerializedName("high")
    val standard: High
)
