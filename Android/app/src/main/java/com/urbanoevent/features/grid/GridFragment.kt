package com.urbanoevent.features.grid

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.urbanoevent.R
import com.urbanoevent.application.UrbanoEventApp
import com.urbanoevent.di.module.GridModule
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.urbanoevent.application.BaseFragment
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
class GridFragment : BaseFragment() {

    val app: UrbanoEventApp
        get() = activity.application as UrbanoEventApp

    val component by lazy { app.component.plus(GridModule(this)) }


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var gridViewModel : GridViewModel
    lateinit var adapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        gridViewModel =  ViewModelProviders.of(activity, viewModelFactory).get(GridViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_grid, container, false)

        val mLayoutManager = LinearLayoutManager(activity);
        view.recycler_view.layoutManager = mLayoutManager
        view.fab.setOnClickListener(onClickAdd())

        return view;
    }

    private fun onClickAdd(): View.OnClickListener? {

        return View.OnClickListener {
            gridViewModel.addUrbanoEvent()
        }
    }




    private fun populateList(urbanoEventList: List<UrbanoEvent>?)
    {
        if(view?.recycler_view?.adapter == null) {
                adapter = GridAdapter(urbanoEventList) {
                    onClickDelete(it)
                }

            view?.recycler_view?.adapter = adapter;
        }
        else
        {
            adapter.updateList(urbanoEventList)
        }
    }

    private fun onClickDelete(urbanoEvent: UrbanoEvent) {

        gridViewModel.deleteUrbanoEvent(urbanoEvent)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridObserver = object : Observer<List<UrbanoEvent>> {
            override fun onChanged(urbanoEventList: List<UrbanoEvent>?) {
                populateList(urbanoEventList)
            }
        }

        gridViewModel.getUrbanoEventList().observe(activity, gridObserver);
    }

}
