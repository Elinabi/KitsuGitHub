package com.example.kitsugithub.models

import com.google.gson.annotations.SerializedName

data class ResponseData(

    @SerializedName("data")
    val data: DataItem
)
