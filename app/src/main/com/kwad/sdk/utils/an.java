package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public final class an {
    public static boolean NS() {
        return isOrientationPortrait();
    }

    public static void b(Context context, boolean z10) {
        try {
            Activity dH = com.kwad.sdk.n.m.dH(context);
            if (dH == null) {
                return;
            }
            if (z10) {
                dH.getWindow().getDecorView().setSystemUiVisibility(1792);
            } else {
                dH.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean cD(Context context) {
        Activity dH = com.kwad.sdk.n.m.dH(context);
        if (dH != null) {
            Window window = dH.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void cE(Context context) {
        Activity dH = com.kwad.sdk.n.m.dH(context);
        if (dH != null) {
            dH.getWindow().clearFlags(1024);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cF(Context context) {
        Activity dH = com.kwad.sdk.n.m.dH(context);
        if (dH != null) {
            dH.setRequestedOrientation(0);
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void cG(Context context) {
        Activity dH = com.kwad.sdk.n.m.dH(context);
        if (dH != null) {
            dH.setRequestedOrientation(1);
        }
    }

    public static boolean isOrientationPortrait() {
        return ServiceProvider.MA().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }
}
