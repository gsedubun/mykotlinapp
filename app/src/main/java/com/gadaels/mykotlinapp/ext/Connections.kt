package com.gadaels.mykotlinapp.ext

import com.gadaels.ext.apiurl
import com.gadaels.mykotlinapp.data.Api
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gadael on 8/26/17.
 */
fun konekRetro(): Api {

    fun getOkhttp(): OkHttpClient{
        val httpLog = HttpLoggingInterceptor();
        httpLog.level = HttpLoggingInterceptor.Level.BODY;
        return OkHttpClient.Builder().addInterceptor(httpLog).build();
    }

    val ret = Retrofit.Builder()
            .client(getOkhttp())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(apiurl)
            .build();

    return ret.create(Api::class.java);

}