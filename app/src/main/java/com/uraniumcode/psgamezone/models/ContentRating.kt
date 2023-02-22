package com.uraniumcode.psgamezone.models

import com.google.gson.annotations.SerializedName


data class ContentRating(

    @SerializedName("description") var description: String? = null,
    @SerializedName("rating_system") var ratingSystem: String? = null,
    @SerializedName("url") var url: String? = null

)