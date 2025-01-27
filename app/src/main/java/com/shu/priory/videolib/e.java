package com.shu.priory.videolib;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: classes3.dex */
public class e {
    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static String a(long j10) {
        if (j10 <= 0 || j10 >= 86400000) {
            return "00:00";
        }
        long j11 = j10 / 1000;
        int i10 = (int) (j11 % 60);
        int i11 = (int) ((j11 / 60) % 60);
        int i12 = (int) (j11 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return (i12 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(i10)) : formatter.format("%02d:%02d", Integer.valueOf(i11), Integer.valueOf(i10))).toString();
    }

    public static void a(Context context, int i10) {
        Activity a10 = a(context);
        if (a10 != null) {
            a10.setRequestedOrientation(i10);
        }
    }
}
