package com.hasanbektas.giphygifs

import com.google.gson.annotations.SerializedName

data class GifModeloriginal (

    @SerializedName("height")
    val height : String,
    @SerializedName("width")
    val width : String,
    @SerializedName("url")
    val url:String

)