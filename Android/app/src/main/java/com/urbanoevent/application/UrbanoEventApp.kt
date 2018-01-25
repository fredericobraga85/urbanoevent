package com.urbanoevent.application

import android.app.Application
import com.urbanoevent.di.component.AppComponent
import com.urbanoevent.di.component.DaggerAppComponent
import com.urbanoevent.di.module.AppModule

/**
 * Created by cinq on 23/01/18.
 */
class UrbanoEventApp : Application()
{
    val component: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }

    override fun onTerminate() {
        super.onTerminate()
    }


}