package com.urbanoevent.model.urbanoevent

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by cinq on 23/01/18.
 */
class UrbanEventRepositoryImpl @Inject constructor(val urbanEventDao: UrbanoEventDAO) : UrbanEventRepository
{

    override fun getUrbanEvent(id: Long): Observable<UrbanoEvent> {

        return Observable.just(urbanEventDao.findById(id))

    }

    override fun getUrbanEventList(): Observable<List<UrbanoEvent>> {

        return Observable.just(urbanEventDao.getAll())
    }


}