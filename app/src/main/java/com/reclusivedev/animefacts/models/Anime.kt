package com.reclusivedev.animefacts.models

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("anime_img")
    val image: String,
    @SerializedName("anime_name")
    val title: String
)
