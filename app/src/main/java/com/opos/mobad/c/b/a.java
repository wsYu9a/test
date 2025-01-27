package com.opos.mobad.c.b;

import android.content.Context;
import com.cdo.oaps.ad.wrapper.BaseWrapper;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f20034a = "FoldUtil";

    /* renamed from: b */
    private static int f20035b = -1;

    public static boolean a(Context context) {
        if (f20035b == -1) {
            int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", BaseWrapper.BASE_PKG_SYSTEM);
            if (identifier <= 0 || !context.getResources().getBoolean(identifier)) {
                f20035b = 0;
            } else {
                f20035b = 1;
            }
        }
        return f20035b == 1;
    }
}
