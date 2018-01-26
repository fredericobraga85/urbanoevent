package com.urbanoevent.utils

import android.os.Bundle
import com.urbanoevent.application.BaseActivity
import com.urbanoevent.features.grid.GridFragment

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

    }

}