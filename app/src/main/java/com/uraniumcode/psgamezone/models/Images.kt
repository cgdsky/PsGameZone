package com.example.example

import com.google.gson.annotations.SerializedName


data class Images(

    @SerializedName("type") var type: Int? = null,
    @SerializedName("url") var url: String? = null

)