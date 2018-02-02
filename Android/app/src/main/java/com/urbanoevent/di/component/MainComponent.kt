package com.urbanoevent.di.component

import com.urbanoevent.application.MainActivity
import com.urbanoevent.di.module.GridModule
import com.urbanoevent.di.module.MainModule
import com.urbanoevent.features.grid.GridFragment
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */

@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(activity: MainActivity)

}