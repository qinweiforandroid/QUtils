package com.qw.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * 软件盘工具类
 * Created by qinwei on 2019/1/21 9:46 AM
 * email: qin.wei@mwee.cn
 */

public class InputMethodUtil {
    /**
     * 隐藏软键盘
     *
     * @param activity A
     */
    public static void hideInput(Activity activity) {
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
