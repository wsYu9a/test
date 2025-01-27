package com.aggmoread.sdk.z.b.m;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    static final String f4696a = "b";

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }

    public static int a(Context context, double d10) {
        return (int) ((d10 * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    public static Drawable a(int i10, float f10, int i11, int i12, int i13) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setAlpha((int) (f10 * 255.0f));
        if (i13 > 0) {
            gradientDrawable.setStroke(i12, i13);
        }
        gradientDrawable.setCornerRadius(i11);
        return gradientDrawable;
    }

    public static void a(TextView textView, int i10) {
        if (textView != null) {
            textView.setTextSize(1, i10);
        }
    }

    public static boolean a(View view) {
        if (view == null) {
            return false;
        }
        boolean z10 = view.getVisibility() == 0;
        boolean isShown = view.isShown();
        boolean globalVisibleRect = Build.VERSION.SDK_INT >= 26 ? view.getGlobalVisibleRect(new Rect()) : true;
        com.aggmoread.sdk.z.b.d.c(f4696a, "isShown enter , isVisible = " + z10 + " , isShown = " + isShown + " , isVisibleRect = " + globalVisibleRect);
        return z10 && isShown && globalVisibleRect;
    }

    public static boolean a(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }
}
