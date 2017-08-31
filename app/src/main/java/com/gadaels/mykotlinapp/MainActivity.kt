package com.gadaels.mykotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gadaels.mykotlinapp.ext.MainPresenter
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {
    override fun onSuccess(title: String, desc: String) {
        toast("$title - $desc");
    }

    private  var presenter: MainPresenter? =null;

    override fun onAttach() {
        presenter?.onAttach(this)
        presenter?.loadData();
    }

    override fun onDetach() {
        presenter?.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()
    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()

    }

    override  fun onResume() {
        onAttach()
        super.onResume()

    }
}
