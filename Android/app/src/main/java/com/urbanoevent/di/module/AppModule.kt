package com.urbanoevent.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.urbanoevent.application.UrbanoEventApp
import com.urbanoevent.database.AppDatabase
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventInteractor
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventInteractorImpl
import com.urbanoevent.features.grid.GridInteractor
import com.urbanoevent.features.grid.GridInteractorImpl
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanEventRepositoryImpl
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */
@Module
class AppModule(val context: Context) {

    @Provides @Singleton fun providesAppContext() = context

    @Provides @Singleton fun providesAppDatabase(context: Context):
            AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "urban_event_db").allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides fun providesUrbanEventDao(database: AppDatabase): UrbanoEventDAO = database.urbanoEventDao()

    @Provides fun providesUrbanEventRepository(urbanEventDao: UrbanoEventDAO): UrbanEventRepository = UrbanEventRepositoryImpl(urbanEventDao)

    @Provides fun providesGridInteractor(urbanEventRepository: UrbanEventRepository) : GridInteractor = GridInteractorImpl(urbanEventRepository)

    @Provides fun providesDetailUrbanoEventInteractor(urbanEventRepository: UrbanEventRepository) : DetailUrbanoEventInteractor = DetailUrbanoEventInteractorImpl(urbanEventRepository)

}