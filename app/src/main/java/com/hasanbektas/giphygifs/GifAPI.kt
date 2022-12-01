package com.hasanbektas.giphygifs

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GifAPI {

    // https://api.giphy.com/v1/gifs/trending?api_key=VNaBgvICOOucKOKIANiaQB7ZUEkGt2wr&limit=25&rating=g
    // https://api.giphy.com/v1/gifs/search?api_key=VNaBgvICOOucKOKIANiaQB7ZUEkGt2wr&q=ball


    @GET("v1/gifs/search")
    fun getData(@Query("api_key") api_key:String, @Query("q") q:String) : Call<GifModel>

}

