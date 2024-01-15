package com.qw.utils

import android.app.Application
import android.os.Environment
import androidx.core.os.EnvironmentCompat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FileManagerTest {
    @Before
    fun setUp() {
        FileManager.init(InstrumentationRegistry.getInstrumentation().context.applicationContext as Application)
    }

    @Test
    fun testFile() {
        Trace.d("imgDir:" + FileManager.imgDir)
        Trace.d("emoDir:" + FileManager.emoDir)
        Trace.d("dowDir:" + FileManager.downloadDir)
        Trace.d("zipDir:" + FileManager.zipDir)
        val dowDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        Trace.d("pucDir:$dowDir")
    }
}