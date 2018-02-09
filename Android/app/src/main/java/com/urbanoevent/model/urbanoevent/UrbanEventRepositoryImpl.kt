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

        val imgUrlList = listOf(
                "https://storage.alboom.ninja/sites/42/albuns/17013/gisele-agata---ricardo-agata---agata-eventos---taboo-eventos---corporativo---petrobras---brmania---stockcar---curitiba--2.jpg",
                "http://www.urbs.curitiba.pr.gov.br/uploads/fotoTurismo/grande/0a26373d98495bb452c0194e4ec4dcabb9057606.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYKQU8l4GI7eWKr2sTVmJfXTrcj9h9KRRVFGBM0EG1ZiDnKnNB1Q",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmkpEEOi9ZzFFhnqDASoHWpNaDAPif2ETGySbzXOOxWstIITOd",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWgnSzkEch9QRKW8YReyec0lwAPe5XzGtMlWs4giRrKQoAgWf31A",
                "http://www.bonde.com.br/img/bondenews/2013/01/img_1_44_5113.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2K5eEDWOvJRsNoViSxdzZczy2JibAWNW46B0ccLmTX6aThRdf",
                "https://gds.portal5g-media.com/contentFiles/system/pictures/2014/4/113122/original/arena3.jpg")


        for (i in 0..10)
        {
            var ue = UrbanoEvent()
            ue.id = i.toLong()
            ue.title = "title_" + i
            ue.desc = "Teste" + i
            ue.imageUrl = imgUrlList.get((i + imgUrlList.size) % imgUrlList.size)

            urbanEventDao.insert(ue)

        }

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