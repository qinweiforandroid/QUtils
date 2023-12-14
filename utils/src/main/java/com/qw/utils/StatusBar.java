package com.qw.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/**
 * create by qinwei at 2022/11/1 22:20
 */
public class StatusBar {
    private final View content;
    private final Activity activity;
    private final WindowInsetsControllerCompat controller;

    public static StatusBar get(Activity activity) {
        return new StatusBar(activity);
    }

    private StatusBar(Activity activity) {
        this.activity = activity;
        this.content = activity.getWindow().getDecorView();
        controller = WindowCompat.getInsetsController(activity.getWindow(), content);
    }

    /**
     * @param isLight true字体黑色,false白色
     * @return
     */
    public StatusBar setAppearanceLightStatusBars(boolean isLight) {
        if (controller != null) {
            controller.setAppearanceLightStatusBars(isLight);
        }
        return this;
    }

    public StatusBar hideStatusBars() {
        if (controller != null) {
            controller.hide(WindowInsetsCompat.Type.statusBars());
        }
        return this;
    }


    public StatusBar hideStatusBarsAndNavigationBars() {
        hideStatusBars();
        hideNavigationBars();
        return this;
    }

    public StatusBar showStatusBarsAndNavigationBars() {
        showStatusBars();
        showNavigationBars();
        return this;
    }

    public StatusBar showStatusBars() {
        if (controller != null) {
            controller.show(WindowInsetsCompat.Type.statusBars());
        }
        return this;
    }

    public StatusBar hideNavigationBars() {
        if (controller != null) {
            controller.hide(WindowInsetsCompat.Type.navigationBars());
        }
        return this;
    }

    public StatusBar showNavigationBars() {
        if (controller != null) {
            controller.show(WindowInsetsCompat.Type.navigationBars());
        }
        return this;
    }

    public StatusBar setAppearanceLightNavigationBars(boolean isLight) {
        if (controller != null) {
            controller.setAppearanceLightNavigationBars(isLight);
        }
        return this;
    }

    public StatusBar setNavigationBarColor(@ColorInt int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(color);
        }
        return this;
    }

    public StatusBar setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(color);
        }
        return this;
    }

    public StatusBar setDecorFitsSystemWindows(boolean decorFitsSystemWindows) {
        WindowCompat.setDecorFitsSystemWindows(activity.getWindow(), decorFitsSystemWindows);
        return this;
    }

    public int getHeight() {
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        var result = 0;
        if (identifier > 0) {
            result = activity.getResources().getDimensionPixelSize(identifier);
        }
        if (result == 0) {
            float scale = activity.getResources().getDisplayMetrics().density;
            result = (int) (25F * scale + 0.5f);
        }
        return result;
    }
}
