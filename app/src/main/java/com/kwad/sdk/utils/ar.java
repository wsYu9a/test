package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
public final class ar {
    public static int ao(Context context, String str) {
        Resources ck = ck(context);
        if (ck == null) {
            ck = context.getResources();
        }
        return ck.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources ck(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.CA().getResources();
    }
}
