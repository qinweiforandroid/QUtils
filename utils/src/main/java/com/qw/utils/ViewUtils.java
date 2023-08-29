package com.qw.utils;

import android.view.View;
import android.view.WindowInsets;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Created by qinwei on 2023/8/29 17:10
 * email: qinwei_it@163.com
 */
class ViewUtils {
    public static void applyWindowInsets(View view) {
        doOnApplyWindowInsets(
                view,
                new OnApplyWindowInsetsListener() {
                    @NonNull
                    @Override
                    public WindowInsetsCompat onApplyWindowInsets(
                            View view,
                            @NonNull WindowInsetsCompat insets,
                            @NonNull RelativePadding initialPadding) {
                        // Apply the bottom, start, and end padding for a BottomNavigationView
                        // to dodge the system navigation bar
                        initialPadding.bottom += insets.getSystemWindowInsetBottom();

                        boolean isRtl = ViewCompat.getLayoutDirection(view) == ViewCompat.LAYOUT_DIRECTION_RTL;
                        int systemWindowInsetLeft = insets.getSystemWindowInsetLeft();
                        int systemWindowInsetRight = insets.getSystemWindowInsetRight();
                        initialPadding.start += isRtl ? systemWindowInsetRight : systemWindowInsetLeft;
                        initialPadding.end += isRtl ? systemWindowInsetLeft : systemWindowInsetRight;
                        initialPadding.applyToView(view);
                        return insets;
                    }
                });
    }

    public static void doOnApplyWindowInsets(
            @NonNull View view, @NonNull final OnApplyWindowInsetsListener listener) {
        // Create a snapshot of the view's padding state.
        final RelativePadding initialPadding =
                new RelativePadding(
                        ViewCompat.getPaddingStart(view),
                        view.getPaddingTop(),
                        ViewCompat.getPaddingEnd(view),
                        view.getPaddingBottom());
        // Set an actual OnApplyWindowInsetsListener which proxies to the given callback, also passing
        // in the original padding state.
        ViewCompat.setOnApplyWindowInsetsListener(
                view,
                new androidx.core.view.OnApplyWindowInsetsListener() {
                    @Override
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets) {
                        return listener.onApplyWindowInsets(view, insets, new RelativePadding(initialPadding));
                    }
                });
        // Request some insets.
        requestApplyInsetsWhenAttached(view);
    }

    /**
     * Wrapper around {@link androidx.core.view.OnApplyWindowInsetsListener} which also passes the
     * OnApplyWindowInsetsListener)}.
     */
    public interface OnApplyWindowInsetsListener {

        /**
         * When {@link View#setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener) set} on a
         * View, this listener method will be called instead of the view's own {@link
         * View#onApplyWindowInsets(WindowInsets)} method. The {@code initialPadding} is the view's
         * original padding which can be updated and will be applied to the view automatically. This
         * method should return a new {@link WindowInsetsCompat} with any insets consumed.
         */
        WindowInsetsCompat onApplyWindowInsets(
                View view, WindowInsetsCompat insets, RelativePadding initialPadding);
    }

    /**
     * Requests that insets should be applied to this view once it is attached.
     */
    public static void requestApplyInsetsWhenAttached(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            // We're already attached, just request as normal.
            ViewCompat.requestApplyInsets(view);
        } else {
            // We're not attached to the hierarchy, add a listener to request when we are.
            view.addOnAttachStateChangeListener(
                    new View.OnAttachStateChangeListener() {
                        @Override
                        public void onViewAttachedToWindow(@NonNull View v) {
                            v.removeOnAttachStateChangeListener(this);
                            ViewCompat.requestApplyInsets(v);
                        }

                        @Override
                        public void onViewDetachedFromWindow(View v) {
                        }
                    });
        }
    }

    public static class RelativePadding {
        public int start;
        public int top;
        public int end;
        public int bottom;

        public RelativePadding(int start, int top, int end, int bottom) {
            this.start = start;
            this.top = top;
            this.end = end;
            this.bottom = bottom;
        }

        public RelativePadding(@NonNull RelativePadding other) {
            this.start = other.start;
            this.top = other.top;
            this.end = other.end;
            this.bottom = other.bottom;
        }

        /**
         * Applies this relative padding to the view.
         */
        public void applyToView(View view) {
            ViewCompat.setPaddingRelative(view, start, top, end, bottom);
        }
    }
}
