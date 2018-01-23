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

    val component by lazy { app.component.plus(GridModule(this)) }
    private var mModel: GridViewModel? = null

    private var mListener: OnFragmentInteractionListener? = null


    private  var tvTitle: TextView? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        mModel = ViewModelProviders.of(activity).get(GridViewModel::class.java)


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_grid, container, false)

        tvTitle = view.findViewById(R.id.tvTitle);

        val gridObserver = object : Observer<List<UrbanoEvent>> {
            override fun onChanged(urbanoEventList: List<UrbanoEvent>?) {

                tvTitle?.setText(urbanoEventList?.get(0)?.title)
            }
        }

        mModel!!.getUrbanoEventList().observe(activity, gridObserver);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GridFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): GridFragment {
            val fragment = GridFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
