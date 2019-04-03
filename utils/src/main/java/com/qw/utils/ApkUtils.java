package com.qw.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * 安装包工具类
 * Created by qinwei on 2019/4/3 3:30 PM
 * email: qin.wei@mwee.cn
 */
public class ApkUtils {
    /**
     * 获取渠道名称
     *
     * @param mContext    上下文
     * @param channel_key 渠道key
     * @return
     */
    public static String getChannelName(Context mContext, String channel_key) {
        try {
            PackageManager packageManager = mContext.getPackageManager();
            if (packageManager != null) {
                //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        return String.valueOf(applicationInfo.metaData.get(channel_key));
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 检测app是否安装
     *
     * @param context     上下文
     * @param packageName 应用唯一标示
     * @return
     */
    public static boolean checkApkExist(Context context, String packageName) {
        if (!TextUtil.isValidate(packageName))
            return false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            Trace.d(info.toString());
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            Trace.d(e.toString());
            return false;
        }
    }
}
