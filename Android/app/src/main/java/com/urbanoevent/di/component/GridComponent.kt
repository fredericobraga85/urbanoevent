package com.urbanoevent.di.component

import com.urbanoevent.di.module.GridModule
import com.urbanoevent.features.grid.GridFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */
@Singleton
@Component(modules = arrayOf(GridModule::class))
interface GridComponent {

    fun inject(fragment: GridFragment)

}