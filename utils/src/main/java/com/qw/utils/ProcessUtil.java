package com.qw.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Method;
import java.util.List;

/**
 * create by qinwei at 2022/1/25 9:45
 */
public class ProcessUtil {
    private static String processName;

    public static boolean isMainProcess(@NonNull Context context) {
        return TextUtils.equals(getProcessName(context), context.getPackageName());

    }

    /**
     * @return 当前进程名
     */
    @Nullable
    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(processName)) {
            return processName;
        }

        //1)通过Application的API获取当前进程名
        processName = getProcessNameByApplication();
        if (!TextUtils.isEmpty(processName)) {
            return processName;
        }

        //2)通过反射ActivityThread获取当前进程名
        processName = getProcessNameByActivityThread();
        if (!TextUtils.isEmpty(processName)) {
            return processName;
        }

        //3)通过ActivityManager获取当前进程名
        processName = getProcessNameByActivityManager(context);

        return processName;
    }

    /**
     * 通过Application新的API获取进程名，无需反射，无需IPC，效率最高。
     */
    public static String getProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            return Application.getProcessName();
        }
        return null;
    }

    /**
     * 通过反射ActivityThread获取进程名，避免了ipc
     */
    public static String getProcessNameByActivityThread() {
        String processName = null;
        try {
            final Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader())
                    .getDeclaredMethod("currentProcessName", (Class<?>[]) new Class[0]);
            declaredMethod.setAccessible(true);
            final Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                processName = (String) invoke;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return processName;
    }

    /**
     * 通过ActivityManager 获取进程名，需要IPC通信
     */
    public static String getProcessNameByActivityManager(@NonNull Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppList = am.getRunningAppProcesses();
            if (runningAppList != null) {
                for (ActivityManager.RunningAppProcessInfo processInfo : runningAppList) {
                    if (processInfo.pid == pid) {
                        return processInfo.processName;
                    }
                }
            }
        }
        return "";
    }
}