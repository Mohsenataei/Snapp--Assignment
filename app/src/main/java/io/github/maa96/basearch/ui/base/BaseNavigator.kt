package io.github.maa96.basearch.ui.base

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity



//TODO("Compare this class and its functionality with navigation architecture component")
/**
 * This interface will handle navigation between fragments and activities in the app
* */
interface BaseNavigator {

    /**
     * Starts an Activity
     *
     * @param activity requester activity
     * @param cls the Activity class to be opened.
     * @param bundle which provides from getCallingBundle()
     */
    fun startActivity(activity: FragmentActivity, cls: Class<*>, bundle: Bundle ) {
        activity.startActivity(Intent(activity,cls).apply { putExtras(bundle) })
    }

    /**
     * Finishes an activity
     * @param activity requester activity */
    fun finishActivity(activity: FragmentActivity) = activity.finish()

    /**
     * Finish an Activity with a result.
     * @param activity requested activity
     * @param resultCode the result code to be set when finishing the Activity.
     */
    fun finishActivityWithResult(activity: FragmentActivity, resultCode: Int, bundle: Bundle) {
        val intent = Intent()
        intent.putExtras(bundle)
        activity.setResult(resultCode, intent)
        activity.finish()
    }

    /**
     * Start a new Activity for a result.
     *
     * @param activity requested activity
     * @param cls         the Activity class to be opened.
     * @param requestCode the request code that will be passed to the opened Activity.
     */
    fun startActivityForResult(activity: FragmentActivity, cls: Class<*>, requestCode: Int, bundle: Bundle) {
        val intent = Intent(activity, cls)
        intent.putExtras(bundle)
        activity.startActivityForResult(intent, requestCode)
    }


    /**
     * attempt to start login activity if  token expired
     *
     * @param activity requested activity
     */
    fun onTokenExpired(activity: FragmentActivity) {
        // todo: open login activity
    }

}