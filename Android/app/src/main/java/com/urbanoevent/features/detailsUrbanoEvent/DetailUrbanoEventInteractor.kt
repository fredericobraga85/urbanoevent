package com.urbanoevent.features.detailsUrbanoEvent

import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.Observable

/**
 * Created by cinq on 23/01/18.
 */
interface DetailUrbanoEventInteractor
{
    fun getUrbanoEvent(id: Long): Observable<UrbanoEvent>

}