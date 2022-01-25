package com.qw.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * SDCard工具类
 * Created by qinwei on 2019/1/21 9:50 AM
 */

public class SDCardUtil {
    public static boolean checkSDCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * sd卡空闲空间
     * 单位Byte
     *
     * @return
     */
    public static long getSDFreeSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long freeBlocks = sf.getAvailableBlocks();
        return freeBlocks * blockSize;
    }

    /**
     * sd卡总空间
     *
     * @return
     */
    public static long getSDAllSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long allBlocks = sf.getBlockCount();
        return allBlocks * blockSize; //单位Byte
    }
}
