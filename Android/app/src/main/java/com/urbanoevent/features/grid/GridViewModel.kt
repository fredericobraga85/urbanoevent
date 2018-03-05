package com.urbanoevent.features.grid


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.urbanoevent.application.BaseViewModel

import com.urbanoevent.model.urbanoevent.UrbanoEvent
import javax.inject.Inject
import android.arch.paging.LivePagedListBuilder
import android.nfc.tech.MifareUltralight.PAGE_SIZE


/**
 * Created by cinq on 23/01/18.
 */
class GridViewModel @Inject constructor(
        private var gridInteractor: GridInteractor): BaseViewModel()
{

    private var urbanoEventList: MutableLiveData<List<UrbanoEvent>>? = null


    companion object {

        private const val PAGE_SIZE = 30
        private const val ENABLE_PLACEHOLDERS = true
    }



    val urbanoEventPagedList = LivePagedListBuilder(gridInteractor.getPagedUrbanoEventList(), PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
            .build()).build()



    fun getUrbanoEventList(): MutableLiveData<List<UrbanoEvent>>? {

        if (urbanoEventList == null) {
            urbanoEventList =  MutableLiveData<List<UrbanoEvent>>();

            loadUrbanoEvents();
        }

        return urbanoEventList
    }


    fun addUrbanoEvent() {

        gridInteractor.addUrbanoEvent()
                .subscribe({
                    _: UrbanoEvent ->
//                    loadUrbanoEvents()
                })
    }

    fun deleteUrbanoEvent(urbanoEvent: UrbanoEvent) {

        gridInteractor.deleteUrbanoEvent(urbanoEvent)
                .subscribe({
//                    loadUrbanoEvents()
                })

    }

    private fun loadUrbanoEvents() {

        gridInteractor
                .getUrbanEventList()
                .subscribe({
                    list: List<UrbanoEvent> ->
                    this.urbanoEventList?.postValue(list);
                })
    }




}