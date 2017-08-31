package com.gadaels.mykotlinapp

import com.gadaels.mykotlinapp.base.View

/**
 * Created by gadael on 8/26/17.
 */
interface MainView : View {
    fun onSuccess(title: String, desc: String)
}