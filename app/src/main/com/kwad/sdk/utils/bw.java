package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes3.dex */
public final class bw {
    public static boolean a(View view, int i10, boolean z10) {
        return view != null && b(view, i10, z10) && cK(view.getContext());
    }

    private static boolean b(View view, int i10, boolean z10) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity dH = com.kwad.sdk.n.m.dH(view.getContext());
        if ((dH != null && dH.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z10 && !view.hasWindowFocus())) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            long height = r9.height() * r9.width();
            long height2 = view.getHeight() * view.getWidth();
            if (height2 > 0 && height * 100 >= i10 * height2) {
                return true;
            }
        }
        return false;
    }

    private static boolean cK(Context context) {
        return at.NU().cK(context);
    }

    public static double k(View view, boolean z10) {
        if (view == null) {
            return -1.0d;
        }
        if (!cK(view.getContext())) {
            return -2.0d;
        }
        if (view.getParent() == null) {
            return -3.0d;
        }
        Activity dH = com.kwad.sdk.n.m.dH(view.getContext());
        if (dH != null && dH.isFinishing()) {
            return -4.0d;
        }
        if (!view.isShown() || view.getVisibility() != 0) {
            return -5.0d;
        }
        if (!view.hasWindowFocus()) {
            return -6.0d;
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            return -8.0d;
        }
        long height = r6.height() * r6.width();
        long height2 = view.getHeight() * view.getWidth();
        if (height2 <= 0) {
            return -7.0d;
        }
        return (height * 100.0d) / height2;
    }

    public static boolean o(View view, int i10) {
        return view != null && b(view, i10, true) && view.hasWindowFocus() && cK(view.getContext());
    }
}
