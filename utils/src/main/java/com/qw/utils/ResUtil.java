package com.qw.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

/**
 * Created by qinwei on 2022/8/8 08:26
 * email: qinwei_it@163.com
 */
public class ResUtil {
    private final static TypedValue typedValue = new TypedValue();

    public static int getColorOfAttr(Context context, int attr) {
        if (context.getTheme().resolveAttribute(attr, typedValue, true)) {
            return typedValue.data;
        }
        return Color.BLACK;
    }

    public static int getResourceOfAttr(Context context, int attr) {
        if (context.getTheme().resolveAttribute(attr, typedValue, true)) {
            return typedValue.resourceId;
        } else {
            return Color.BLACK;
        }
    }

}
