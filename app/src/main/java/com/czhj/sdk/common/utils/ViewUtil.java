package com.czhj.sdk.common.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class ViewUtil {
    public static View a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static Activity getActivityFromView(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Activity getActivityFromViewTop(View view) {
        View rootViewFromView = getRootViewFromView(view);
        if (rootViewFromView != null) {
            return getActivityFromView(rootViewFromView);
        }
        return null;
    }

    public static View getRootViewFromView(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(R.id.content);
        return findViewById != null ? findViewById : rootView;
    }

    public static View getTopmostView(Context context, View view) {
        View a10 = a(context);
        return a10 != null ? a10 : getRootViewFromView(view);
    }

    public static boolean isPointInView(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        return rawY >= i11 && rawY <= view.getMeasuredHeight() + i11 && rawX >= i10 && rawX <= view.getMeasuredWidth() + i10;
    }

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
