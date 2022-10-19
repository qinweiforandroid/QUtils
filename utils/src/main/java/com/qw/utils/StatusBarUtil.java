package com.qw.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

/**
 * Created by qinwei on 2019-06-11 09:22
 * email: qinwei_it@163.com
 */
public class StatusBarUtil {
    /**
     * @param activity
     * @param dark     true 灰色  false 白色
     */
    public static void setLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        int visibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        if (dark) {
            //黑色字体
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                visibility = visibility | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
        }
        decor.setSystemUiVisibility(visibility);
        setStatusBarColor(activity, Color.TRANSPARENT);
        setNavigationBarColor(activity, Color.TRANSPARENT);
    }

    /**
     * 5.0及以上系统支持状态栏着色
     *
     * @param activity 状态栏对应的界面
     * @param color    状态栏颜色
     */
    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(color);
        }
    }

    /**
     * 5.0及以上系统支持
     *
     * @param activity 导航栏对应的界面
     * @param color    着色的颜色
     */
    public static void setNavigationBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(color);
        }
    }

    public static void setFullscreen(Activity activity) {
        if (activity.hasWindowFocus() && Build.VERSION.SDK_INT >= 19) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        var result = 0;
        if (identifier > 0) {
            result = context.getResources().getDimensionPixelSize(identifier);
        }
        if (result == 0) {
            float scale = context.getResources().getDisplayMetrics().density;
            result = (int) (25F * scale + 0.5f);
        }
        return result;
    }

    public static void setNormal(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
}