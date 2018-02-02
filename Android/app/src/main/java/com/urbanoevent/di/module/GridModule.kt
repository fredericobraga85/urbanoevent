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
@Module
class GridModule(val fragment: GridFragment) {

//    @Provides fun providesGridInteractor(urbanEventRepository: UrbanEventRepository) : GridInteractor = GridInteractorImpl(urbanEventRepository)

}