package com.urbanoevent.di.module

import android.arch.lifecycle.ViewModelProviders
import com.urbanoevent.application.BaseActivity
import com.urbanoevent.features.grid.GridFragment
import com.urbanoevent.features.grid.GridViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by cinq on 23/01/18.
 */
@Module
class GridModule(val fragment: GridFragment) {

    @Provides
    fun providesGridViewModel(activity: BaseActivity) = ViewModelProviders.of(activity).get(GridViewModel::class.java)

}