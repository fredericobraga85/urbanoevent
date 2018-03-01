package com.urbanoevent.di.component

import com.urbanoevent.di.module.DetailUrbanoEventModule
import com.urbanoevent.di.module.GridModule
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventActivity
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventViewModel
import com.urbanoevent.features.grid.GridFragment
import com.urbanoevent.features.grid.GridViewModel
import dagger.Subcomponent

/**
 * Created by cinq on 23/01/18.
 */

@Subcomponent(modules = arrayOf(DetailUrbanoEventModule::class))
interface DetailUrabnoEventComponent {

    fun inject(activity: DetailUrbanoEventActivity)
    fun inject(detailUrbanoEventViewModel: DetailUrbanoEventViewModel)

}