package com.urbanoevent.features.grid

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.Observable
import javax.inject.Inject


/**
 * Created by cinq on 23/01/18.
 */
interface GridInteractor
{
    fun getUrbanEventList(): Observable<List<UrbanoEvent>>
    fun updateUrbanoEvent(title: String): Observable<List<UrbanoEvent>>

}