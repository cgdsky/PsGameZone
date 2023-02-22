package com.example.example

import com.google.gson.annotations.SerializedName


data class DefaultSku(

    @SerializedName("augmented_description") var augmentedDescription: String? = null,
    @SerializedName("display_price") var displayPrice: String? = null,
    @SerializedName("end_date") var endDate: String? = null,
    @SerializedName("entitlements") var entitlements: ArrayList<Languages> = arrayListOf(),
    @SerializedName("playability_date") var playabilityDate: String? = null,

    )