package com.urbanoevent.model.urbanoevent

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


/**
 * Created by cinq on 23/01/18.
 */
@Dao
interface UrbanoEventDAO {

    @get:Query("SELECT * FROM urbano_events")
    val all: List<UrbanoEvent>

    @Query("SELECT * FROM urbano_events WHERE uid IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<UrbanoEvent>

    @Query("SELECT * FROM urbano_events WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): UrbanoEvent

    @Insert
    fun insertAll(vararg urbanoEvents: UrbanoEvent)

    @Delete
    fun delete(urbanoEvent: UrbanoEvent)
}