package com.martian.ttbook.b.a.k;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    static final String f15043a = "b";

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }

    public static int b(Context context, double d2) {
        double d3 = context.getResources().getDisplayMetrics().density;
        Double.isNaN(d3);
        return (int) ((d2 * d3) + 0.5d);
    }

    public static void c(TextView textView, int i2) {
        if (textView != null) {
            textView.setTextSize(1, i2);
        }
    }

    public static boolean d(View view) {
        if (view == null) {
            return false;
        }
        boolean z = view.getVisibility() == 0;
        boolean isShown = view.isShown();
        boolean globalVisibleRect = Build.VERSION.SDK_INT >= 26 ? view.getGlobalVisibleRect(new Rect()) : true;
        b.d.e.c.a.d.k(f15043a, "isShown enter , isVisible = " + z + " , isShown = " + isShown + " , isVisibleRect = " + globalVisibleRect);
        return z && isShown && globalVisibleRect;
    }

    public static boolean e(View view, View view2) {
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
