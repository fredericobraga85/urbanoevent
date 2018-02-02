package com.urbanoevent.di.component

import com.urbanoevent.di.module.GridModule
import com.urbanoevent.features.grid.GridFragment
import com.urbanoevent.features.grid.GridViewModel
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */

@Subcomponent(modules = arrayOf(GridModule::class))
interface GridComponent {

    fun inject(fragment: GridFragment)
    fun inject(gridViewModel: GridViewModel)

}