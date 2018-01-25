package com.urbanoevent.di.component

import com.urbanoevent.application.UrbanoEventApp
import com.urbanoevent.di.module.AppModule
import com.urbanoevent.di.module.GridModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(app: UrbanoEventApp)
//    fun plus(gridModule: GridModule): GridComponent
}