package com.kwad.sdk.api.core;

import android.content.Context;

/* loaded from: classes3.dex */
public class ApiViewUtil {
    public static int px2dip(Context context, float f10) {
        return (int) ((f10 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
