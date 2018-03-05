package com.urbanoevent.features.grid

import android.arch.paging.DataSource
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.Observable



/**
 * Created by cinq on 23/01/18.
 */
interface GridInteractor
{
    fun getUrbanEventList(): Observable<List<UrbanoEvent>>
    fun addUrbanoEvent(): Observable<UrbanoEvent>
    fun deleteUrbanoEvent(urbanoEvent: UrbanoEvent): Observable<Unit>

    fun getPagedUrbanoEventList(): DataSource.Factory<Int, UrbanoEvent>

}