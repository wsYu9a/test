package com.jd.ad.sdk.jad_fq;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes2.dex */
public class jad_dq {
    public static boolean jad_an(Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }
}
