package com.example.example

import com.google.gson.annotations.SerializedName
import com.uraniumcode.psgamezone.models.ContentRating
import com.uraniumcode.psgamezone.models.MediaList


data class GameDetail(

    @SerializedName("age_limit") var ageLimit: Int? = null,
    @SerializedName("content_rating") var contentRating: ContentRating? = ContentRating(),
    @SerializedName("default_sku") var defaultSku: DefaultSku? = DefaultSku(),
    @SerializedName("game_contentType") var gameContentType: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("images") var images: ArrayList<Images> = arrayListOf(),
    @SerializedName("long_desc") var longDesc: String? = null,
    @SerializedName("mediaList") var mediaList: MediaList? = MediaList(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("playable_platform") var playablePlatform: ArrayList<String> = arrayListOf(),
    @SerializedName("provider_name") var providerName: String? = null,
    @SerializedName("release_date") var releaseDate: String? = null,
    @SerializedName("url") var url: String? = null,

    )