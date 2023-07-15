package com.example.youtubeapi.data.model.video

import com.google.gson.annotations.SerializedName

data class High(

    @SerializedName("width")
    val width: Int = 0,

    @SerializedName("url")
    val url: String = "",

    @SerializedName("height")
    val height: Int = 0

)
