package com.qw.utils

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
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
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mMainDarkBtn -> {
                StatusBarUtil.setLightStatusBar(this, true)
            }
            R.id.mMainLightBtn -> {
                StatusBarUtil.setLightStatusBar(this, false)
            }
            R.id.mMainFullBtn -> {
                StatusBarUtil.setFullscreen(this)
            }
            R.id.mMainNormalBtn -> {
                StatusBarUtil.setNormal(this)
            }
            else -> {

            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}