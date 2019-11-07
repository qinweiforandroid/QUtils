package com.qw.utils

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.qw.utils.sample.R
import kotlinx.android.synthetic.main.main_activity.*

/**
 * Created by qinwei on 2019-06-11 09:31
 * email: qinwei_it@163.com
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    .or(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
                    .or(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
        StatusBarUtil.setStatusBarColor(this, Color.TRANSPARENT)
        StatusBarUtil.setNavigationBarColor(this, Color.TRANSPARENT)
        supportActionBar?.hide()
        mMainDarkBtn.setOnClickListener(this)
        mMainLightBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mMainDarkBtn -> {
                StatusBarUtil.setAndroidNativeLightStatusBar(this, true)
            }
            R.id.mMainLightBtn -> {
                StatusBarUtil.setAndroidNativeLightStatusBar(this, false)
            }
            else -> {

            }
        }
    }
}