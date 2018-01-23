package com.urbanoevent.model.urbanoevent

import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.Observable

/**
 * Created by cinq on 23/01/18.
 */
interface UrbanEventRepository
{
    fun getUrbanEvent(id: Long): Observable<UrbanoEvent>
    fun getUrbanEventList(): Observable<List<UrbanoEvent>>
    
}