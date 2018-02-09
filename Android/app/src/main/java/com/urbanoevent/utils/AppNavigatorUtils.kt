package com.urbanoevent.utils

import android.content.Context
import android.os.Bundle
import com.urbanoevent.application.BaseActivity
import com.urbanoevent.features.grid.GridFragment
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.app.ActivityOptionsCompat
import android.content.Intent
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventActivity


/**
 * Created by cinq on 24/01/18.
 */
class AppNavigatorUtils
{
    companion object {

        fun openGridFragment(activity: BaseActivity, bundle: Bundle, idFrame: Int) {
            val fragment = GridFragment()
            fragment.setArguments(bundle)
            activity.getSupportFragmentManager().beginTransaction().replace(idFrame, fragment).commit()
        }

        fun openDetailUrbanoEventActivity(context: Context, urbanoEvent: UrbanoEvent) {

//            https@ //github.com/codepath/android_guides/wiki/Shared-Element-Activity-Transition

//            val intent = Intent(context, DetailUrbanoEventActivity::class.java)
//            intent.putExtra(DetailUrbanoEventActivity.EXTRA_URBANOEVENT, urbanoEvent)
//            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, ivProfile as View, "profile")
//            startActivity(intent, options.toBundle())
        }

    }

}