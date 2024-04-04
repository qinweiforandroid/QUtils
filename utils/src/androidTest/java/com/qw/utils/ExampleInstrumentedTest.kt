package com.qw.utils

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.qw.utils.DensityUtil.dpi
import com.qw.utils.DensityUtil.dp
import com.qw.utils.DensityUtil.getScreenHeight
import com.qw.utils.DensityUtil.getScreenWidth
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private var appContext: Context? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().context
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        Assert.assertEquals("com.qw.utils.test", appContext!!.packageName)
    }

    @Test
    fun testNetWork() {
        Trace.setTag("NetworkUtil")
        val isConnected = NetworkUtil.isConnected(appContext)
        Trace.d("isConnected:$isConnected")
        val ip = NetworkUtil.getLocalIpAddress()
        Trace.d("ip:$ip")
    }

    @Test
    fun testDensityUtil() {
        // Context of the app under test.
        Trace.setTag("DensityUtil")
        val dpi = dpi
        val w = getScreenWidth(appContext!!)
        val h = getScreenHeight(appContext!!)
        Trace.d("dpi $dpi w:$w,h:$h")
        Trace.d("2dp=" + 2.dp + "px")
    }

    @Test
    fun testApk() {
        Trace.setTag("ApkUtils")
        val isInstalled = ApkUtil.isInstalled(appContext, "com.tencent.mobileqq")
        Assert.assertTrue("未安装", isInstalled)
    }

    @Test
    fun testSDCard() {
        Trace.setTag("SDCardUtil")
        val isExist = SDCardUtil.checkSDCard()
        if (isExist) {
            Trace.d("SDCard挂载")
        } else {
            Trace.d("SDCard不存在")
        }
        val freeSize = SDCardUtil.getSDFreeSize()
        Trace.d("freeSize:" + freeSize * 1.0 / 1024 / 1024 + "M")
        val allSize = SDCardUtil.getSDAllSize()
        Trace.d("freeSize:" + allSize * 1.0 / 1024 / 1024 + "M")
    }
}
