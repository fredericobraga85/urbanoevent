package com.urbanoevent.di.module

import android.arch.lifecycle.ViewModelProvider
import com.urbanoevent.di.ViewModelFactory
import com.urbanoevent.features.grid.*
import dagger.Binds
import dagger.Module

/**
 * Created by cinq on 23/01/18.
 */
import android.arch.lifecycle.ViewModel
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventViewModel
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey( GridViewModel::class )
    // Bind your View Model here
    abstract fun bindMainViewModel( gridViewModel: GridViewModel ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( DetailUrbanoEventViewModel::class )
    // Bind your View Model here
    abstract fun bindDetailUrbanoEventViewModel( detailUrbanoEventViewModel: DetailUrbanoEventViewModel ): ViewModel


    @Binds
    abstract fun bindViewModelFactory( factory: ViewModelFactory):
            ViewModelProvider.Factory

}