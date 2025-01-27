package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class ax {
    public static int au(Context context, String str) {
        Resources cM = cM(context);
        if (cM == null) {
            cM = context.getResources();
        }
        return cM.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources cM(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.MA().getResources();
    }

    public static int getAppIconId(Context context) {
        int i10;
        try {
            i10 = ao.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i10 = 0;
        }
        return i10 <= 0 ? au(context, "ksad_notification_small_icon") : i10;
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB() ? "com.kwad.sdk" : context.getPackageName();
    }
}
