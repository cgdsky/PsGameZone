package com.example.example

import com.google.gson.annotations.SerializedName


data class Languages(

    @SerializedName("subtitle_language_codes") var subtitleLanguageCodes: Array<String>? = null,
    @SerializedName("voice_language_codes") var voiceLanguageCodes: Array<String>? = null

)