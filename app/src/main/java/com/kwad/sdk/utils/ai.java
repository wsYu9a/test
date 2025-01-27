package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
public final class ai {
    public static boolean DL() {
        return DM();
    }

    public static boolean DM() {
        return ServiceProvider.CA().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }

    public static void b(Context context, boolean z) {
        try {
            Activity dj = com.kwad.sdk.j.k.dj(context);
            if (dj == null) {
                return;
            }
            if (z) {
                if (Build.VERSION.SDK_INT < 19) {
                    dj.getWindow().getDecorView().setSystemUiVisibility(8);
                    return;
                } else {
                    dj.getWindow().getDecorView().setSystemUiVisibility(1792);
                    return;
                }
            }
            if (Build.VERSION.SDK_INT < 19) {
                dj.getWindow().getDecorView().setSystemUiVisibility(0);
            } else {
                dj.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean cb(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            Window window = dj.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void cc(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            dj.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cd(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            dj.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void ce(Context context) {
        Activity dj = com.kwad.sdk.j.k.dj(context);
        if (dj != null) {
            dj.setRequestedOrientation(1);
        }
    }
}
