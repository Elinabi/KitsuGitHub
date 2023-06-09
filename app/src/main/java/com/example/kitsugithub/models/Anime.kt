package com.example.kitsugithub.models

import com.google.gson.annotations.SerializedName

data class Anime<T>(
    @SerializedName("data")
    val data: List<T>,

    @SerializedName("links")
    val links: Links
)