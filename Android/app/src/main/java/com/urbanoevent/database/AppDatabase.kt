package com.urbanoevent.database

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO


/**
 * Created by cinq on 23/01/18.
 */
@Database(entities = arrayOf(UrbanoEvent::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun urbanoEventDao(): UrbanoEventDAO
}