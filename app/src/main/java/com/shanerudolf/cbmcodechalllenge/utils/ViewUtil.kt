package com.shanerudolf.cbmcodechalllenge.utils

import android.content.res.Resources
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by shane1 on 2/8/18.
 */
class ViewUtil {
    companion object {
        fun getDisplaySize(windowManager: WindowManager): Point {
            try {
                val display = windowManager.defaultDisplay
                val displayMetrics = DisplayMetrics()
                display.getMetrics(displayMetrics)
                return Point(displayMetrics.widthPixels, displayMetrics.heightPixels)
            } catch (e: Exception) {
                e.printStackTrace()
                return Point(0, 0)
            }
        }

        fun dpToPx(dp: Int): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }
    }
}