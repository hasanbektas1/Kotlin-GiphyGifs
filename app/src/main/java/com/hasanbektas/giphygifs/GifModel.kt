package com.hasanbektas.giphygifs

import com.google.gson.annotations.SerializedName

data class GifModel (

        @SerializedName("data")
        val data : List<GifDataModel>

        )