package com.qw.utils

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.qw.utils.sample.R

/**
 * Created by qinwei on 2019-06-11 09:31
 * email: qinwei_it@163.com
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mMainDarkBtn: Button
    private lateinit var mMainLightBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        ToastUtils.injectToast(ToastImpl(application))
        mMainDarkBtn = findViewById(R.id.mMainDarkBtn)
        mMainLightBtn = findViewById(R.id.mMainLightBtn)
        findViewById<View>(R.id.mMainFullBtn).setOnClickListener(this)
        findViewById<View>(R.id.mMainNormalBtn).setOnClickListener(this)
        mMainDarkBtn.setOnClickListener(this)
        mMainLightBtn.setOnClickListener(this)
        findViewById<Button>(R.id.mMainDarkBtn)

        Trace.d("statusBarHeight," + StatusBar.get(this).statusBarHeight.toString())
        Trace.d("navigationBarHeight," + StatusBar.get(this).navigationBarHeight.toString())

        val uri = Uri.Builder()
            .scheme("dl")
            .authority("dl.com")
            .path("app/main")
            .appendQueryParameter("a", "1")
            .appendQueryParameter("b", "2")
            .build()
        println(uri.toString())
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mMainDarkBtn -> {
                StatusBar.get(this)
                    .setDecorFitsSystemWindows(false)
                    .setStatusBarColor(Color.TRANSPARENT)
                    .setNavigationBarColor(Color.TRANSPARENT)
                    .setAppearanceLightStatusBars(true)
                    .setAppearanceLightNavigationBars(true)
                ToastUtils.show("mMainDarkBtn")
            }

            R.id.mMainLightBtn -> {
                StatusBar.get(this)
                    .setDecorFitsSystemWindows(false)
                    .setStatusBarColor(Color.TRANSPARENT)
                    .setNavigationBarColor(Color.TRANSPARENT)
                    .setAppearanceLightStatusBars(false)
                    .setAppearanceLightNavigationBars(false)
            }

            R.id.mMainFullBtn -> {
                StatusBar.get(this).hideStatusBarsAndNavigationBars()
            }

            R.id.mMainNormalBtn -> {
                StatusBar.get(this)
                    .setDecorFitsSystemWindows(true)
                    .showStatusBarsAndNavigationBars()
            }

            else -> {

            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}