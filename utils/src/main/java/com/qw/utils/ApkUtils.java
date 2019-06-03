package com.qw.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

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
     * @return 渠道名称
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
     * @return true已安装 false 未安装
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

    /**
     * 应用安装
     *
     * @param context
     * @param authority android 清单文件中配置的内容 provider标签下的authorities属性
     * @param file      apk文件
     */
    public static void loadInstallApk(Context context, String authority, File file) {
        if (!file.exists()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 24) {
            Uri apkUri = FileProvider.getUriForFile(context, authority, file);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }
}
