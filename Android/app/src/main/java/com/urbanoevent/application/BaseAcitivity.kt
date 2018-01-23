package com.urbanoevent.application

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.arch.lifecycle.LifecycleRegistry
import javax.inject.Inject


/**
 * Created by cinq on 23/01/18.
 */
open class BaseAcitivity : AppCompatActivity(), LifecycleOwner
{

    private var mLifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this);

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        mLifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    override fun onStart() {
        super.onStart()
        mLifecycleRegistry.markState(Lifecycle.State.STARTED)
    }


    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry;
    }
}