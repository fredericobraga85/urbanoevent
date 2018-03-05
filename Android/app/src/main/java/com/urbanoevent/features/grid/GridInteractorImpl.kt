package com.urbanoevent.features.grid

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO
import com.urbanoevent.model.urbanoevent.UrbanoEventDAO.Companion.imgUrlList
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers
import java.util.*

import javax.inject.Inject


/**
 * Created by cinq on 23/01/18.
 */
class GridInteractorImpl(val urbanEventRepository: UrbanEventRepository):GridInteractor
{


    override fun getUrbanEventList(): Observable<List<UrbanoEvent>> {

        return  urbanEventRepository.getUrbanEventList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    override fun addUrbanoEvent(): Observable<UrbanoEvent> {

        return getUrbanEventList().flatMap{

            val id = if(it.isEmpty()) 0 else it.size

            var ue = UrbanoEvent()
            ue.id = id.toLong()
            ue.title = "title_" + id
            ue.desc = "desc_" + id
            ue.imageUrl = UrbanoEventDAO.imgUrlList.get(Random().nextInt(imgUrlList.size))

            urbanEventRepository.addUrbanoEvent(ue)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
    }

    override fun deleteUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<Unit> {

        return urbanEventRepository.deleteUrbanoEvent(urbanoEvent)
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }


    override fun getPagedUrbanoEventList(): DataSource.Factory<Int, UrbanoEvent> {

        return urbanEventRepository.getPagedUrbanoEventList()

    }

}
