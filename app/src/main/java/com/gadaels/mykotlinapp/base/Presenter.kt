package com.gadaels.mykotlinapp.base

import android.app.Application
import com.gadaels.mykotlinapp.di.MyAppComponent

/**
 * Created by gadael on 8/26/17.
 */

interface  Presenter<in T: View>{

    fun onAttach(view: T)

    fun onDetach()
}


interface  View {
    fun onAttach()
    fun onDetach()
}

class MyKotlinApp: Application(){
    companion object {
        lateinit var  appComp: MyAppComponent

    }

    override fun onCreate() {
        super.onCreate()

        appComp = MyAppComponent.builder().appModule(AppModule(this)).build()
    }
}