package com.example.youtubeapi.data.model.category

import com.google.gson.annotations.SerializedName

 data class VideoCategory (

    @SerializedName("kind")
    val kind : String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("snippet")
    val snippet: Snippet
 )
