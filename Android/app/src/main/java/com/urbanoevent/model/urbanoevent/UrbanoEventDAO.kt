package com.urbanoevent.model.urbanoevent

import android.arch.paging.DataSource
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

    @Query("select * from urbano_events")
    fun getPagedUrbanoEventList(): DataSource.Factory<Int, UrbanoEvent>

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

    companion object {
        val imgUrlList = listOf(
                "https://storage.alboom.ninja/sites/42/albuns/17013/gisele-agata---ricardo-agata---agata-eventos---taboo-eventos---corporativo---petrobras---brmania---stockcar---curitiba--2.jpg",
                "http://www.urbs.curitiba.pr.gov.br/uploads/fotoTurismo/grande/0a26373d98495bb452c0194e4ec4dcabb9057606.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYKQU8l4GI7eWKr2sTVmJfXTrcj9h9KRRVFGBM0EG1ZiDnKnNB1Q",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmkpEEOi9ZzFFhnqDASoHWpNaDAPif2ETGySbzXOOxWstIITOd",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWgnSzkEch9QRKW8YReyec0lwAPe5XzGtMlWs4giRrKQoAgWf31A",
                "http://www.bonde.com.br/img/bondenews/2013/01/img_1_44_5113.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2K5eEDWOvJRsNoViSxdzZczy2JibAWNW46B0ccLmTX6aThRdf",
                "https://gds.portal5g-media.com/contentFiles/system/pictures/2014/4/113122/original/arena3.jpg")
    }


}