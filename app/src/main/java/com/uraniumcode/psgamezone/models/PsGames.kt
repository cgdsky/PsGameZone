package com.example.example

import com.google.gson.annotations.SerializedName


data class PsGames(
    @SerializedName("links") var gameDetails: ArrayList<GameDetail> = arrayListOf(),
    @SerializedName("name") var name: String? = null,
)