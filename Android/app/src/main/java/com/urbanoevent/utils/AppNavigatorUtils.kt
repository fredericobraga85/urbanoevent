package com.urbanoevent.utils

import android.content.Context
import android.os.Bundle
import com.urbanoevent.application.BaseActivity
import com.urbanoevent.features.grid.GridFragment
import com.urbanoevent.model.urbanoevent.UrbanoEvent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.app.ActivityOptionsCompat
import android.content.Intent
import android.view.View
import com.urbanoevent.features.detailsUrbanoEvent.DetailUrbanoEventActivity
import com.urbanoevent.R.id.imageView
import android.support.v4.view.ViewCompat




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

        fun openDetailUrbanoEventActivity(context: Context, id: Long, options: ActivityOptionsCompat?) {

//            https@ //github.com/codepath/android_guides/wiki/Shared-Element-Activity-Transition

            val intent = Intent(context, DetailUrbanoEventActivity::class.java)
            intent.putExtra(DetailUrbanoEventActivity.EXTRA_URBANOEVENT_ID, id)
            startActivity(context, intent, options?.toBundle());
        }

    }

}