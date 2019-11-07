package com.qw.utils;

import android.content.Context;
import android.net.Uri;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

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
        Uri uri = Uri.parse("ilisten:///topic/info?vip_is_free=1&id=542&title=专题列表");
        System.out.println("Authority "+uri.getAuthority());
        System.out.println("Path "+uri.getPath());
        System.out.println("size "+uri.getQueryParameterNames().size());
        assertEquals("com.qw.utils", appContext.getPackageName());
    }
}
