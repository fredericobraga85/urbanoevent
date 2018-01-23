package com.urbanoevent.di.module

import com.urbanoevent.application.UrbanoEventApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */
@Module
class AppModule(val app: UrbanoEventApp) {

    @Provides @Singleton
    fun provideApp() = app
}