package com.urbanoevent.features.grid

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import com.urbanoevent.model.urbanoevent.UrbanoEvent


/**
 * Created by cinq on 23/01/18.
 */
class GridViewModel: ViewModel()
{

    private var urbanoEvent: MutableLiveData<List<UrbanoEvent>>? = null

    fun getUrbanoEventList(): MutableLiveData<List<UrbanoEvent>> {

        if (urbanoEvent == null) {
            urbanoEvent =  MutableLiveData<List<UrbanoEvent>>();
        }

        return urbanoEvent!!
    }


    private fun loadUrbanoEvents() {
        // Do an asyncronous operation to fetch users.
    }

}