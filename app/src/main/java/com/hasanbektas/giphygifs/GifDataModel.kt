package com.hasanbektas.giphygifs

import com.google.gson.annotations.SerializedName

data class GifDataModel (

    @SerializedName("type")
    val type : String,
    @SerializedName("id")
    val id : String,
    @SerializedName("url")
    val url:String,
    @SerializedName("embed_url")
    val embedurl:String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val images: GifModelimages

        )