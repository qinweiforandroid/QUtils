package com.qw.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by qinwei on 2020/11/28 4:51 PM
 * email: qinwei_it@163.com
 */
public class SPUtil {
    public SharedPreferences getSP(Context context, String name) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public SharedPreferences.Editor getEditor(Context context, String name) {
        return getSP(context, name).edit();
    }

    public void putBoolean(Context context, String name, String key, boolean value) {
        getEditor(context, name).putBoolean(key, value).commit();
    }

    public void putFloat(Context context, String name, String key, float value) {
        getEditor(context, name).putFloat(key, value).commit();
    }

    public void putInt(Context context, String name, String key, int value) {
        getEditor(context, name).putInt(key, value).commit();
    }

    public void putLong(Context context, String name, String key, long value) {
        getEditor(context, name).putLong(key, value).commit();
    }

    public void putString(Context context, String name, String key, String value) {
        getEditor(context, name).putString(key, value).commit();
    }
}