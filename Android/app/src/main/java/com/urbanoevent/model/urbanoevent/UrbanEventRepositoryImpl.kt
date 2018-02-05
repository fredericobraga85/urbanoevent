package com.urbanoevent.model.urbanoevent

import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject

/**
 * Created by cinq on 23/01/18.
 */
class UrbanEventRepositoryImpl @Inject constructor(val urbanEventDao: UrbanoEventDAO) : UrbanEventRepository
{


    init{

        var ue1 = UrbanoEvent()
        ue1.id = 1
        ue1.title = "title1"
        ue1.desc = "Teste1"

        var ue2 = UrbanoEvent()
        ue2.id = 2
        ue2.title = "title2"
        ue2.desc = "Teste2"

        var ue3 = UrbanoEvent()
        ue3.id = 3
        ue3.title = "title3"
        ue3.desc = "Teste3"

        var ue4 = UrbanoEvent()
        ue4.id = 4
        ue4.title = "title4"
        ue4.desc = "Teste4"

        var ue5 = UrbanoEvent()
        ue5.id = 5
        ue5.title = "title5"
        ue5.desc = "Teste5"


        urbanEventDao.insert(ue1)
        urbanEventDao.insert(ue2)
        urbanEventDao.insert(ue3)
        urbanEventDao.insert(ue4)
        urbanEventDao.insert(ue5)

    }


    override fun getUrbanEvent(id: Long): Observable<UrbanoEvent> {

        return Observable.just(urbanEventDao.findById(id))
    }


    override fun getUrbanEventList(): Observable<List<UrbanoEvent>> {

        return Observable.just(urbanEventDao.getAll())
    }

    override fun addUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<UrbanoEvent> {

        return Observable.just( urbanEventDao.insert(urbanoEvent))
                .flatMap{
                    Observable.just(urbanoEvent)
                }
    }


    override fun deleteUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<Unit> {

        return Observable.just(urbanEventDao.delete(urbanoEvent))



    }



}