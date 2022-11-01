package com.qw.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/**
 * create by qinwei at 2022/11/1 22:20
 */
public class StatusBar {
    private final View content;
    private final Activity activity;

    public static StatusBar get(Activity activity) {
        return new StatusBar(activity);
    }

    private StatusBar(Activity activity) {
        this.activity = activity;
        this.content = activity.findViewById(android.R.id.content);
    }

    public StatusBar setAppearanceLightStatusBars(boolean isLight) {
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(activity.getWindow(), content);
        if (controller != null) {
            controller.setAppearanceLightStatusBars(isLight);
        }
        return this;
    }

    public StatusBar setAppearanceLightNavigationBars(boolean isLight) {
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(activity.getWindow(), content);
        if (controller != null) {
            controller.setAppearanceLightNavigationBars(isLight);
        }
        return this;
    }

    public StatusBar setNavigationBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(activity.getResources()
                    .getColor(color));
        }
        return this;
    }

    public StatusBar setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(activity.getResources()
                    .getColor(color));
        }
        return this;
    }

    public StatusBar setDecorFitsSystemWindows(boolean decorFitsSystemWindows) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !decorFitsSystemWindows) {
            setStatusBarColor(android.R.color.transparent);
        }
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
