package com.urbanoevent.di.module

import android.content.Context
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventInteractor
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventInteractorImpl
import com.urbanoevent.features.grid.GridInteractor
import com.urbanoevent.features.grid.GridInteractorImpl
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanEventRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cinq on 23/01/18.
 */
@Module
class AppModule(val context: Context) {

    @Provides @Singleton fun providesAppContext() = context

//    @Provides @Singleton fun providesAppDatabase(context: Context):
//            RoomDB = RoomDB.get(context)
//
//    @Provides fun providesUrbanEventDao(database: RoomDB): UrbanoEventDAO = database.urbanoEventDao()

    @Provides fun providesUrbanEventRepository(context: Context): UrbanEventRepository = UrbanEventRepositoryImpl(context)

    @Provides fun providesGridInteractor(urbanEventRepository: UrbanEventRepository) : GridInteractor = GridInteractorImpl(urbanEventRepository)

    @Provides fun providesDetailUrbanoEventInteractor(urbanEventRepository: UrbanEventRepository) : DetailUrbanoEventInteractor = DetailUrbanoEventInteractorImpl(urbanEventRepository)

}