package com.urbanoevent.features.grid

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
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
import android.widget.ImageView
import com.urbanoevent.application.BaseFragment
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import com.urbanoevent.utils.AppNavigatorUtils
import kotlinx.android.synthetic.main.fragment_grid.view.*
import javax.inject.Inject
import com.urbanoevent.R.id.imageView
import android.support.v4.view.ViewCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper


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
        get() = activity?.application as UrbanoEventApp

    val component by lazy { app.component.plus(GridModule(this)) }


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var gridViewModel : GridViewModel
//    lateinit var adapter: GridAdapter
    lateinit var adapter: GridPagedListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component.inject(this)

        gridViewModel =  ViewModelProviders.of(activity!!, viewModelFactory).get(GridViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_grid, container, false)

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


//    private fun populateList(urbanoEventList: List<UrbanoEvent>?)
//    {
//        if(view?.recycler_view?.adapter == null) {
//                adapter = GridPagedListAdapter(urbanoEventList) { urbanoEvent: UrbanoEvent, imageView: ImageView ->
//
//                    onClickItem(urbanoEvent, imageView)
//
//                }
//
//            view?.recycler_view?.adapter = adapter;
//        }
//        else
//        {
//            adapter.updateList(urbanoEventList)
//        }
//    }

    private fun onClickItem(urbanoEvent: UrbanoEvent, imageView: ImageView) {

             val options = ActivityOptionsCompat.makeSceneTransitionAnimation( activity as Activity,
                imageView,
                ViewCompat.getTransitionName(imageView))

            AppNavigatorUtils.openDetailUrbanoEventActivity(activity as Activity, urbanoEvent.id, options)

    }

    private fun onClickDelete(urbanoEvent: UrbanoEvent) {

        gridViewModel.deleteUrbanoEvent(urbanoEvent)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val gridObserver = object : Observer<List<UrbanoEvent>> {
//            override fun onChanged(urbanoEventList: List<UrbanoEvent>?) {
//                populateList(urbanoEventList)
//            }
//        }

        adapter = GridPagedListAdapter(listOf()) { urbanoEvent: UrbanoEvent, imageView: ImageView ->

            onClickItem(urbanoEvent, imageView)

        }

        view.recycler_view?.adapter = adapter;

        gridViewModel.urbanoEventPagedList?.observe(activity as LifecycleOwner, Observer(adapter::submitList));

        initSwipeToDelete()
    }


    private fun initSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            // enable the items to swipe to the left or right
            override fun getMovementFlags(recyclerView: RecyclerView,
                                          viewHolder: RecyclerView.ViewHolder): Int =
                    makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean = false

            // When an item is swiped, remove the item via the view model. The list item will be
            // automatically removed in response, because the adapter is observing the live list.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                (viewHolder as? GridPagedListAdapter.GridViewHolder)?.urbanoEvent?.let {
                    gridViewModel.deleteUrbanoEvent(it)
                }
            }
        }).attachToRecyclerView(view?.recycler_view)
    }

}
