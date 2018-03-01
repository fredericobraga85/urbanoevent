package com.urbanoevent.features.detailsUrbanoEvent

import android.arch.lifecycle.MutableLiveData
import com.urbanoevent.application.BaseViewModel
import com.urbanoevent.features.grid.GridInteractor
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import javax.inject.Inject

/**
 * Created by cinq on 23/01/18.
 */
class DetailUrbanoEventViewModel @Inject constructor(
        private var detailUrbanoInteractor: DetailUrbanoEventInteractor): BaseViewModel()
{

    private var urbanoEvent: MutableLiveData<UrbanoEvent>? = null


    fun getUrbanoEvent(id: Long): MutableLiveData<UrbanoEvent> {

        if (urbanoEvent == null) {
            urbanoEvent = MutableLiveData<UrbanoEvent>();

            loadUrbanoEvent(id);
        }

        return urbanoEvent!!
    }


    private fun loadUrbanoEvent(id: Long) {

        detailUrbanoInteractor
                .getUrbanoEvent(id)
                .subscribe({
                    ue: UrbanoEvent ->
                    this.urbanoEvent!!.postValue(ue);
                })
    }




}