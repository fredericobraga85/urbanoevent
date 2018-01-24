package com.urbanoevent.model.urbanoevent

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE


/**
 * Created by cinq on 23/01/18.
 */
@Dao
interface UrbanoEventDAO {

//    @get:Query("SELECT * FROM urbano_events")
//    val all: List<UrbanoEvent>


    @Query("select * from urbano_events")
    fun getAll(): List<UrbanoEvent>

    @Query("SELECT * FROM urbano_events WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<UrbanoEvent>

    @Query("select * FROM urbano_events where id = (:id)")
    fun findById(id: Long): UrbanoEvent

    @Insert(onConflict = REPLACE)
    fun insert(urbanoEvent: UrbanoEvent)

    @Update(onConflict = REPLACE)
    fun update(urbanoEvent: UrbanoEvent)

    @Delete
    fun delete(urbanoEvent: UrbanoEvent)
}