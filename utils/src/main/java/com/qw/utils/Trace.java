package com.qw.utils;

import android.util.Log;

public class Trace {
    private static String TAG = "qinwei";
    private static boolean debug = true;
    private static ILog log = new ILog() {
        @Override
        public void v(String tag, String msg) {
            Log.v(tag, msg + "");
        }

        @Override
        public void d(String tag, String msg) {
            Log.d(tag, msg + "");
        }

        @Override
        public void i(String tag, String msg) {
            Log.i(tag, msg + "");
        }

        @Override
        public void w(String tag, String msg) {
            Log.w(tag, msg + "");
        }

        @Override
        public void e(String tag, String msg) {
            Log.e(tag, msg + "");
        }
    };

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

    public static void inject(ILog log) {
        Trace.log = log;
    }

    public interface ILog {
        void v(String tag, String msg);

        void d(String tag, String msg);

        void i(String tag, String msg);

        void w(String tag, String msg);

        void e(String tag, String msg);
    }


    public static String getTraceInfo() {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stacks = new Throwable().getStackTrace();
        sb.append("class: ").append(stacks[1].getClassName())
                .append("; method: ").append(stacks[1].getMethodName())
                .append("; number: ").append(stacks[1].getLineNumber());

        return sb.toString();
    }

    public static void v(String tag, String msg) {
        if (debug) {
            log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (debug) {
            log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (debug) {
            log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (debug) {
            log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (debug) {
            log.e(tag, msg);
        }
    }

    /**
     * 设置全局tag
     *
     * @param tag tag
     */
    public static void setTag(String tag) {
        Trace.TAG = tag;
    }

    /**
     * 设置开发模式
     *
     * @param debug debug
     */
    public static void setDebug(boolean debug) {
        Trace.debug = debug;
    }
}
