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
    private lateinit var mMainStatusTransparentBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        StatusBarUtil.setLightStatusBar(this, false)
        mMainDarkBtn = findViewById(R.id.mMainDarkBtn)
        mMainLightBtn = findViewById(R.id.mMainLightBtn)
        mMainStatusTransparentBtn = findViewById(R.id.mMainStatusTransparentBtn)
        mMainDarkBtn.setOnClickListener(this)
        mMainLightBtn.setOnClickListener(this)
        mMainStatusTransparentBtn.setOnClickListener(this)

        findViewById<Button>(R.id.mMainDarkBtn)


        supportActionBar?.hide()
        val process = ProcessUtil.getProcessName(this)

        Trace.d("process", "$process isMain:${ProcessUtil.isMainProcess(this)}")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mMainDarkBtn -> {
                StatusBarUtil.setLightStatusBar(this, true)
            }
            R.id.mMainLightBtn -> {
                StatusBarUtil.setLightStatusBar(this, false)
            }
            R.id.mMainStatusTransparentBtn -> {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
            else -> {

            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}