package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.splashscreen.h;

/* loaded from: classes2.dex */
public final class c {
    public static void a(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i3 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), i3);
            }
            if (i4 >= 0) {
                marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), i4);
            }
            if (i5 >= 0) {
                marginLayoutParams.rightMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), i5);
            }
        }
    }

    public static boolean a(Context context, int i2, int i3) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        int a2 = com.kwad.sdk.c.kwai.a.a(context, 10.0f);
        return Math.abs(i2 - i4) <= a2 && Math.abs(i3 - i5) <= a2;
    }

    public static boolean c(h hVar) {
        int i2 = hVar.Bz;
        return i2 == 2 || i2 == 3;
    }

    public static int d(h hVar) {
        int i2 = hVar.Bz;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 3 || i2 == 1) {
            return 2;
        }
        return i2 == 2 ? 3 : 1;
    }
}
