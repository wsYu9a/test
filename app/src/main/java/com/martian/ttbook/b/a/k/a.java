package com.martian.ttbook.b.a.k;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/* loaded from: classes4.dex */
public class a {
    public static boolean a(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return false;
    }
}
