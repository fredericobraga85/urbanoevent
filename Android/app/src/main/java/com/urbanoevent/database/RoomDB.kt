package com.urbanoevent.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.content.Context
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO.Companion.imgUrlList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/**
 * Created by fred_braga on 23/01/18.
 */
@Database(entities = arrayOf(UrbanoEvent::class), version = 2)
abstract class RoomDB : RoomDatabase() {

    abstract fun urbanoEventDao(): UrbanoEventDAO


    companion object {
        private var instance: RoomDB? = null
        @Synchronized
        fun get(context: Context): RoomDB {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        RoomDB::class.java, "urban_event_db")
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                fillInDb(context.applicationContext)
                            }
                        })
//                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance!!
        }

        /**
         * fill database with list of cheeses
         */
        private fun fillInDb(context: Context) {


            Observable.just(get(context).urbanoEventDao())
                    .flatMap { dao ->
                        for (i in 0..100)
                        {
                            var ue = UrbanoEvent()
                            ue.id = i.toLong()
                            ue.title = "title_" + i
                            ue.desc = "Teste" + i
                            ue.imageUrl = imgUrlList.get((i + imgUrlList.size) % imgUrlList.size)

                            dao.insert(ue)
                        }

                        Observable.just(null)
                    }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            {  },
                            {Timber.e("Error populating DB " + it.localizedMessage)},
                            {Timber.d("Succesfully populated DB.")}
                    )
        }
    }





//    Room.databaseBuilder(context, RoomDB::class.java, "urban_event_db").allowMainThreadQueries().fallbackToDestructiveMigration().build()
}


