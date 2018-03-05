package com.urbanoevent.model.urbanoevent

import android.arch.paging.DataSource
import android.content.Context
import com.urbanoevent.database.RoomDB
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by cinq on 23/01/18.
 */
class UrbanEventRepositoryImpl(val context: Context) : UrbanEventRepository
{


    override fun getUrbanEvent(id: Long): Observable<UrbanoEvent> {

        return getDaoObs().map{it.findById(id)}
    }


    override fun getUrbanEventList(): Observable<List<UrbanoEvent>> {

        return getDaoObs().map {it.getAll()}
    }

    override fun addUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<UrbanoEvent> {

        return getDaoObs().map {it.insert(urbanoEvent)}
                .flatMap{
                    Observable.just(urbanoEvent)
                }
    }


    override fun deleteUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<Unit> {

        return getDaoObs().map{it.delete(urbanoEvent)}

    }


    override fun getPagedUrbanoEventList(): DataSource.Factory<Int, UrbanoEvent> {
        return getDao().getPagedUrbanoEventList()
    }


    fun getDaoObs(): Observable<UrbanoEventDAO>
    {
        return Observable.just(RoomDB.get(context).urbanoEventDao())
                .subscribeOn(Schedulers.io())
    }


    fun getDao(): UrbanoEventDAO
    {
        return RoomDB.get(context).urbanoEventDao()

    }


}