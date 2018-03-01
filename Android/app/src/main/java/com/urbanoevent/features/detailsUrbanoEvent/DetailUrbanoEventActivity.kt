package com.urbanoevent.features.detailsUrbanoEvent

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.urbanoevent.R
import com.urbanoevent.application.UrbanoEventApp
import com.urbanoevent.di.module.DetailUrbanoEventModule
import com.urbanoevent.di.module.MainModule
import com.urbanoevent.features.grid.GridViewModel
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import kotlinx.android.synthetic.main.activity_detail_urbano_event.*
import kotlinx.android.synthetic.main.grid_item_view.view.*
import javax.inject.Inject

class DetailUrbanoEventActivity : AppCompatActivity() {

    companion object {
        val EXTRA_URBANOEVENT_ID = "EXTRA_URBANOEVENT_ID"
    }


    val Activity.app: UrbanoEventApp
        get() = application as UrbanoEventApp

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    val component by lazy { app.component.plus(DetailUrbanoEventModule(this)) }

    lateinit var detailUrbanoEventViewModel : DetailUrbanoEventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_urbano_event)

        component.inject(this)


        var id:Long =  intent.getLongExtra(EXTRA_URBANOEVENT_ID, -1)

        detailUrbanoEventViewModel =  ViewModelProviders.of(this, viewModelFactory).get(DetailUrbanoEventViewModel::class.java)

        val detailUrbanoEventObserver = object : Observer<UrbanoEvent> {
            override fun onChanged(urbanoEvent: UrbanoEvent?) {
                showUrbanoEvent(urbanoEvent)
            }
        }

        detailUrbanoEventViewModel.getUrbanoEvent(id).observe(this, detailUrbanoEventObserver);

    }

    private fun showUrbanoEvent(urbanoEvent: UrbanoEvent?) {

        with(urbanoEvent) {
            tvTitle.text = urbanoEvent?.title
            tvDesc.text  = urbanoEvent?.desc

            com.bumptech.glide.Glide.with(applicationContext)
                    .load(urbanoEvent?.imageUrl)
                    .apply(com.bumptech.glide.request.RequestOptions().centerCrop())
                    .into(imgView);

        }
    }


}
