package com.qw.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.qw.utils.test", appContext.getPackageName());
    }


    @Test
    public void testNetWork() {
        Trace.setTag("NetworkUtil");
        boolean isConnected = NetworkUtil.isConnected(InstrumentationRegistry.getTargetContext());
        Trace.d("isConnected:" + isConnected);
        String ip = NetworkUtil.getLocalIpAddress();
        Trace.d("ip:" + ip);

    }

    @Test
    public void testDensityUtil() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        Trace.setTag("DensityUtil");
        int dpi = DensityUtil.getDPI(appContext);
        int w = DensityUtil.getScreenWidth(appContext);
        int h = DensityUtil.getScreenHeight(appContext);
        Trace.d("dpi " + dpi + " w:" + w + ",h:" + h);
        Trace.d("2dp=" + DensityUtil.dip2px(appContext, 2) + "px");
    }

    @Test
    public void testApk() {
        Trace.setTag("ApkUtils");
        boolean isInstalled = ApkUtils.checkApkExist(InstrumentationRegistry.getTargetContext(), "com.tencent.mobileqq");
        if (isInstalled) {
            Trace.d("qq已安装");
        } else {
            Trace.d("qq未安装");
        }
    }

    @Test
    public void testSDCard() {
        Trace.setTag("SDCardUtil");
        boolean isExist = SDCardUtil.checkSDCard();
        if (isExist) {
            Trace.d("SDCard挂载");
        } else {
            Trace.d("SDCard不存在");
        }
        long freeSize = SDCardUtil.getSDFreeSize();
        Trace.d("freeSize:" + freeSize * 1.0 / 1024 / 1024 + "M");
        long allSize = SDCardUtil.getSDAllSize();
        Trace.d("freeSize:" + allSize * 1.0 / 1024 / 1024 + "M");

    }
}
