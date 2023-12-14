package com.qw.utils

import android.app.Application
import java.io.File

/**
 * @author Stay
 * @version create time：Mar 24, 2015 10:47:15 AM
 */
object FileManager {
    private lateinit var context: Application
    fun init(application: Application) {
        this.context = application
    }

    private val ROOT: String
        get() {
            return context.filesDir.absolutePath
        }

    private val tmpDir: String
        get() {
            return context.cacheDir.absolutePath
        }

    val zipDir: String
        get() {
            val dir = ROOT + File.separator + "zipDir"
            return checkDir(dir)
        }

    fun createTmpFile(): String {
        return tmpDir + File.separator + System.currentTimeMillis() + ".tmp"
    }

    fun createTmpFile(name: String): String {
        return tmpDir + File.separator + name
    }

    val downloadDir: String
        get() {
            val dir = ROOT + File.separator + "download"
            return checkDir(dir)
        }
    val imgDir: String
        get() {
            val dir = ROOT + File.separator + "img"
            return checkDir(dir)
        }
    val emoDir: String
        get() {
            val dir = ROOT + File.separator + "emo"
            return checkDir(dir)
        }

    fun getEmoDir(group: String): String {
        val dir = emoDir + File.separator + group
        return checkDir(dir)
    }

    fun getEmoPath(group: String, emo: String): String {
        return getEmoDir(group) + File.separator + emo
    }

    private fun checkDir(dir: String): String {
        val directory = File(dir)
        if (!directory.exists() || !directory.isDirectory) {
            directory.mkdirs()
        }
        return dir
    }

    fun getDownloadPath(name: String): String {
        return downloadDir + File.separator + name
    }

    fun deleteFile(path: String?) {
        val file = File(path)
        if (file.exists()) {
            file.delete()
        }
    }


}