package com.opos.mobad.c.b;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: classes4.dex */
public class d {
    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
