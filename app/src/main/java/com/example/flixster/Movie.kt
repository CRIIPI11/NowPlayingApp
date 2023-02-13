package com.example.flixster

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("title")
    val title:String? = null

    @SerializedName("overview")
    val description:String? = null

    @SerializedName("poster_path")
    val imageUrl:String? = null
}