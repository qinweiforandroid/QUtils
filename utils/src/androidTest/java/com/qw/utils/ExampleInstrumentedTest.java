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
        boolean isConnected = NetworkUtil.isConnected(InstrumentationRegistry.getTargetContext());
        System.out.println("isConnected:" + isConnected);
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
}
