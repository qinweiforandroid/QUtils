package com.qw.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Point
import android.util.TypedValue
import android.view.WindowManager

object DensityUtil {

    val Float.dp
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this,
            Resources.getSystem().displayMetrics
        )
    val Int.dp
        get() = this.toFloat().dp

    @JvmStatic
    fun dip2px(dp: Float): Float {
        return dp.dp
    }

    @JvmStatic
    fun dip2px(dp: Int): Float {
        return dp.dp
    }

    @JvmStatic
    fun getScreenWidth(context: Context): Int {
        return getScreen(context).x
    }

    @JvmStatic
    fun getScreenHeight(context: Context): Int {
        return getScreen(context).y
    }

    @JvmStatic
    fun getScreen(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val outSize = Point()
        display.getSize(outSize)
        return outSize
    }

    @JvmStatic
    val dpi: Int
        get() {
            val dm = Resources.getSystem().displayMetrics
            return dm.densityDpi
        }

    /**
     * 判断当前设备是手机还是平板，代码来自 Google I/O App for Android
     *
     * @param context
     * @return 平板返回 True，手机返回 False
     */
    fun isPadDevice(context: Context): Boolean {
        return ((context.resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }
}
