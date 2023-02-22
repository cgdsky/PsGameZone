package com.uraniumcode.psgamezone.models

import com.google.gson.annotations.SerializedName


data class Screenshots(

    @SerializedName("type") var type: String? = null,
    @SerializedName("url") var url: String? = null,

    )