package com.qw.utils;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * SDCard工具类
 * Created by qinwei on 2019/1/21 9:50 AM
 * email: qin.wei@mwee.cn
 */

public class SDCardUtil {
    /**
     * 判断存储卡是否存在
     *
     * @return true 存在 false 不存在
     */
    public static boolean checkSDCard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * @return 单位mb
     * @Description 获取sdcard可用空间的大小
     */
    public static long getSDFreeSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long freeBlocks = sf.getAvailableBlocks();
        // return freeBlocks * blockSize; //单位Byte
        // return (freeBlocks * blockSize)/1024; //单位KB
        return (freeBlocks * blockSize) / 1024 / 1024; // 单位MB
    }

    /**
     * 获取sdcard总容量
     *
     * @return
     */
    private static long getSDAllSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs sf = new StatFs(path.getPath());
        long blockSize = sf.getBlockSize();
        long allBlocks = sf.getBlockCount();
        // 返回SD卡大小
        // return allBlocks * blockSize; //单位Byte
        // return (allBlocks * blockSize)/1024; //单位KB
        return (allBlocks * blockSize) / 1024 / 1024; // 单位MB
    }


}
