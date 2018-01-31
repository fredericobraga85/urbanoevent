package com.urbanoevent.features.grid

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers

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

        return urbanEventRepository.addUrbanoEvent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    override fun deleteUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<Unit> {

        return urbanEventRepository.deleteUrbanoEvent(urbanoEvent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
