package com.gadaels.mykotlinapp.data

import android.telecom.Call
import com.google.gson.annotations.SerializedName
import java.util.*
import javax.xml.transform.Result

/**
 * Created by gadael on 8/26/17.
 */
data class MovieResponse(@SerializedName("page")val page: Int,
                         @SerializedName("total_results") val total_results: Long,
                         @SerializedName("total_pages") val total_pages: Long,
                         @SerializedName("results") val results: List<Result>){

    data class Result(val id: Int, val title: String, val overview: String, val release_date: Date)

}
