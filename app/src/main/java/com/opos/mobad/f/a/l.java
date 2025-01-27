package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import org.apache.http.HttpStatus;

/* loaded from: classes4.dex */
public class l {
    public static int a(Context context) {
        return context != null ? (int) ((com.opos.cmn.an.h.f.a.b(context) * 0.3778f) + 0.5f) : HttpStatus.SC_GATEWAY_TIMEOUT;
    }

    public static boolean a(ViewGroup viewGroup, View view) {
        if (viewGroup != null && view != null) {
            try {
                if (view.getParent() == null) {
                    viewGroup.addView(view);
                    return true;
                }
                com.opos.cmn.an.f.a.b("InterSplash$SplashViewUtils", String.format("addView failed:The %s already has a parent.", view));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("InterSplash$SplashViewUtils", "", e2);
            }
        }
        return false;
    }

    public static boolean a(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            try {
                if (view.getParent() == null) {
                    viewGroup.addView(view, layoutParams);
                    return true;
                }
                com.opos.cmn.an.f.a.b("InterSplash$SplashViewUtils", String.format("addView failed:The %s already has a parent.", view));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("InterSplash$SplashViewUtils", "", e2);
            }
        }
        return false;
    }
}
