package com.urbanoevent.features.grid

import android.arch.lifecycle.Observer
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.urbanoevent.R
import com.urbanoevent.application.UrbanoEventApp
import com.urbanoevent.di.module.GridModule
import android.arch.lifecycle.ViewModelProviders
import android.widget.TextView
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import kotlinx.android.synthetic.main.fragment_grid.view.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GridFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GridFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GridFragment : Fragment() {

    val app: UrbanoEventApp
        get() = activity.application as UrbanoEventApp


    @Inject
    lateinit var mModel: GridViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val component by lazy { app.component.inject(GridModule(this)) }
        component.inject(this)

        mModel = ViewModelProviders.of(activity).get(GridViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_grid, container, false)


        val gridObserver = object : Observer<List<UrbanoEvent>> {
            override fun onChanged(urbanoEventList: List<UrbanoEvent>?) {

                view.tvTitle?.setText(urbanoEventList?.get(0)?.title)
            }
        }

        mModel!!.getUrbanoEventList().observe(activity, gridObserver);

        return view;
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }



}
