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
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mMainDarkBtn -> {
                val controller =
                    WindowCompat.getInsetsController(window, findViewById(R.id.mRoot))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.statusBarColor = Color.TRANSPARENT
                    window.navigationBarColor = Color.TRANSPARENT
                }
                controller?.let {
                    it.isAppearanceLightStatusBars = true
                    it.isAppearanceLightNavigationBars = true
                }
            }
            R.id.mMainLightBtn -> {
                val controller =
                    WindowCompat.getInsetsController(window, findViewById(R.id.mRoot))
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.statusBarColor = Color.TRANSPARENT
                    window.navigationBarColor = Color.TRANSPARENT
                }
                controller?.let {
                    it.isAppearanceLightStatusBars = false
                    it.isAppearanceLightNavigationBars = false
                }
            }
            R.id.mMainFullBtn -> {
                val controller =
                    WindowCompat.getInsetsController(window, findViewById(R.id.mRoot))
                controller?.let {
                    it.hide(WindowInsetsCompat.Type.systemBars())
                    it.systemBarsBehavior =
                        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }
            R.id.mMainNormalBtn -> {
                val controller =
                    WindowCompat.getInsetsController(window, findViewById(R.id.mRoot))
                controller?.show(WindowInsetsCompat.Type.systemBars())
            }
            else -> {

            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}