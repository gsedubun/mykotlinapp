package com.gadaels.mykotlinapp.ext

//import com.gadaels.mykotlinapp.MainView
import android.util.Log
import com.gadaels.ext.apikey
import com.gadaels.mykotlinapp.MainView
import com.gadaels.mykotlinapp.base.Presenter
import com.gadaels.mykotlinapp.base.View
import com.gadaels.mykotlinapp.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by gadael on 8/26/17.
 */
class MainPresenter : Presenter<MainView>{

    private  var view: MainView? =null


    override fun onAttach(view: MainView) {
        this.view = view;
    }

    override fun onDetach() {
    this.view=null
    }

    fun loadData(){
        val api  = konekRetro().discoverMovie(apikey).enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                //Log.e("Movie", response?.message())
                val data: List<MovieResponse.Result>? = response?.body()?.results

                data?.map {
                    val title = it.title
                    val desc = it.overview
                    view?.onSuccess(title,desc);
                }
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.e("Movie", t?.message)
            }

        })
    }

}

