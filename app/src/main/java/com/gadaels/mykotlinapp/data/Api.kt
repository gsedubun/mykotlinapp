package com.gadaels.mykotlinapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by gadael on 8/26/17.
 */

interface  Api{
    @GET("3/discover/movie")
    fun discoverMovie(@Query("api_key")apiKey: String): Call<MovieResponse>
}