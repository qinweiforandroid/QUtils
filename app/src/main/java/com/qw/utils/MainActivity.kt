package com.qw.utils

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
        mMainDarkBtn = findViewById(R.id.mMainDarkBtn)
        mMainLightBtn = findViewById(R.id.mMainLightBtn)
        findViewById<View>(R.id.mMainFullBtn).setOnClickListener(this)
        findViewById<View>(R.id.mMainNormalBtn).setOnClickListener(this)
        mMainDarkBtn.setOnClickListener(this)
        mMainLightBtn.setOnClickListener(this)
        findViewById<Button>(R.id.mMainDarkBtn)
        println(StatusBar.get(this).height)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mMainDarkBtn -> {
//                StatusBarUtil.setLightStatusBar(this, true)
                StatusBar.get(this)
                    .setDecorFitsSystemWindows(false)
                    .setNavigationBarColor(android.R.color.transparent)
                    .setAppearanceLightStatusBars(true)
                    .setAppearanceLightNavigationBars(true)
            }
            R.id.mMainLightBtn -> {
                StatusBar.get(this)
                    .setDecorFitsSystemWindows(false)
                    .setNavigationBarColor(android.R.color.transparent)
                    .setAppearanceLightStatusBars(false)
                    .setAppearanceLightNavigationBars(false)
//                StatusBarUtil.setLightStatusBar(this, false)
            }
            R.id.mMainFullBtn -> {
//                StatusBarUtil.setFullscreen(this)
                StatusBar.get(this).hideStatusBarsAndNavigationBars()
            }
            R.id.mMainNormalBtn -> {
                StatusBar.get(this).showStatusBarsAndNavigationBars()
//                StatusBarUtil.setNormal(this)
            }
            else -> {

            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}