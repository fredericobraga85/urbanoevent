package com.urbanoevent.features.grid


import android.arch.lifecycle.MutableLiveData
import com.urbanoevent.application.BaseViewModel

import com.urbanoevent.model.urbanoevent.UrbanoEvent
import javax.inject.Inject


/**
 * Created by cinq on 23/01/18.
 */
class GridViewModel @Inject constructor(
        private var gridInteractor: GridInteractor): BaseViewModel()
{

    private var urbanoEventList: MutableLiveData<List<UrbanoEvent>>? = null


    fun getUrbanoEventList(): MutableLiveData<List<UrbanoEvent>> {

        if (urbanoEventList == null) {
            urbanoEventList =  MutableLiveData<List<UrbanoEvent>>();

            loadUrbanoEvents();
        }

        return urbanoEventList!!
    }


    private fun loadUrbanoEvents() {

        gridInteractor
                .getUrbanEventList()
                .subscribe({
                    list: List<UrbanoEvent> ->
                    this.urbanoEventList!!.postValue(list);
                })

    }

    fun onClickUpdateUrbanoEvent() {

        gridInteractor.updateUrbanoEvent( "_teste")
                .subscribe({
                    list: List<UrbanoEvent> ->
                    this.urbanoEventList!!.postValue(list);
                })
    }

}