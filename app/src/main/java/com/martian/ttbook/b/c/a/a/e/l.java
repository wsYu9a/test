package com.martian.ttbook.b.c.a.a.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/* loaded from: classes4.dex */
public class l {
    public static int a(double d2) {
        return c(com.martian.ttbook.b.c.a.a.d.b.j.q, d2);
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }

    public static int c(Context context, double d2) {
        double d3 = context.getResources().getDisplayMetrics().density;
        Double.isNaN(d3);
        return (int) ((d2 * d3) + 0.5d);
    }
}
