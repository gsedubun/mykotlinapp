package com.gadaels.mykotlinapp.di

import android.app.Application
import android.content.Context
import com.gadaels.mykotlinapp.MainActivity
import com.gadaels.mykotlinapp.base.MyKotlinApp
import com.gadaels.mykotlinapp.ext.MainPresenter
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by gadael on 8/29/17.
 */
@Singleton
@Component( modules = arrayOf(AppModule::class, NetWorkModule::class, MovieModule::class))
interface MyAppComponent{
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)
}

@Module
class NetWorkModule {

}
@Module
class AppModule( val app: MyKotlinApp)  {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}

@Module
object MovieModule {

}
