package com.qw.utils;

import android.util.Log;

public class Trace {
    private static String TAG = "qinwei";

    public static boolean model = true;

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }


    public static String getTraceInfo() {
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        sb.append("class: ").append(stacks[1].getClassName())
                .append("; method: ").append(stacks[1].getMethodName())
                .append("; number: ").append(stacks[1].getLineNumber());

        return sb.toString();
    }

    public static void v(String tag, String msg) {
        if (model) {
            Log.v(tag, msg + "");
        }
    }

    public static void d(String tag, String msg) {
        if (model) {
            Log.d(tag, msg + "");
        }
    }

    public static void i(String tag, String msg) {
        if (model) {
            Log.i(tag, msg + "");
        }
    }

    public static void w(String tag, String msg) {
        if (model) {
            Log.w(tag, msg + "");
        }
    }

    public static void e(String tag, String msg) {
        if (model) {
            Log.e(tag, msg + "");
        }
    }

    public static void setTag(String tag) {
        Trace.TAG = tag;
    }
}
