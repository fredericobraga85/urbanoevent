package com.urbanoevent.features.detailsUrbanoEvent

import com.urbanoevent.features.grid.GridInteractor
import com.urbanoevent.model.urbanoevent.UrbanEventRepository
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by cinq on 23/01/18.
 */
class DetailUrbanoEventInteractorImpl(val urbanEventRepository: UrbanEventRepository): DetailUrbanoEventInteractor
{
    override fun getUrbanoEvent(id: Long): Observable<UrbanoEvent> {
        return  urbanEventRepository.getUrbanEvent(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


}