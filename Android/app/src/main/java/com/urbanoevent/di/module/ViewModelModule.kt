package com.urbanoevent.di.module

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.urbanoevent.application.BaseActivity
import com.urbanoevent.application.MainActivity
import com.urbanoevent.database.AppDatabase
import com.urbanoevent.di.ViewModelFactory
import com.urbanoevent.features.grid.*
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanEventRepositoryImpl
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by cinq on 23/01/18.
 */
import android.arch.lifecycle.ViewModel
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey( GridViewModel::class )
    // Bind your View Model here
    abstract fun bindMainViewModel( gridViewModel: GridViewModel ): ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: ViewModelFactory):
            ViewModelProvider.Factory

}