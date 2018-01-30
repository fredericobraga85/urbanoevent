package com.urbanoevent.di.component

import com.urbanoevent.application.UrbanoEventApp
import com.urbanoevent.di.module.AppModule
import com.urbanoevent.di.module.GridModule
import com.urbanoevent.di.module.MainModule
import com.urbanoevent.di.module.ViewModelModule
import com.urbanoevent.features.grid.GridViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,ViewModelModule::class))
interface AppComponent {

    fun inject(app: UrbanoEventApp)
    fun plus(mainModule: MainModule): MainComponent
    fun plus(gridModule: GridModule): GridComponent
    fun inject(gridViewModle: GridViewModel): GridViewModel
}