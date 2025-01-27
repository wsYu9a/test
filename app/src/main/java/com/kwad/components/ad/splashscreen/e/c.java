package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class c {
    public static void a(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i11 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), i11);
            }
            marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 16.0f);
        }
    }

    public static boolean z(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.skipButtonPosition == 0;
    }

    public static boolean a(Context context, int i10, int i11) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i12 = displayMetrics.widthPixels;
        int i13 = displayMetrics.heightPixels;
        int a10 = com.kwad.sdk.c.a.a.a(context, 10.0f);
        return Math.abs(i10 - i12) <= a10 && Math.abs(i11 - i13) <= a10;
    }
}
