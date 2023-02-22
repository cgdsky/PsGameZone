package com.uraniumcode.psgamezone.models

import com.google.gson.annotations.SerializedName


data class MediaList(

    @SerializedName("screenshots") var screenshots: ArrayList<Screenshots> = arrayListOf()

)