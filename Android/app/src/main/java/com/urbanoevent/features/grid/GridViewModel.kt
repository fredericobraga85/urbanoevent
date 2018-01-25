package com.urbanoevent.features.grid

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.MutableLiveData
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.HalfSerializer.onComplete
import javax.inject.Inject


/**
 * Created by cinq on 23/01/18.
 */
class GridViewModel: ViewModel()
{

    @Inject
    lateinit var gridInteractor: GridInteractor


    private var urbanoEvent: MutableLiveData<List<UrbanoEvent>>? = null

    fun getUrbanoEventList(): MutableLiveData<List<UrbanoEvent>> {

        if (urbanoEvent == null) {
            urbanoEvent =  MutableLiveData<List<UrbanoEvent>>();

            loadUrbanoEvents();
        }

        return urbanoEvent!!
    }


    private fun loadUrbanoEvents() {

        gridInteractor
                .getUrbanEventList()
                .subscribe({
                    list: List<UrbanoEvent> ->
                    this.urbanoEvent!!.postValue(list);
                })

    }

}