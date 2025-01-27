package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes2.dex */
public final class bl {
    public static boolean a(View view, int i2, boolean z) {
        return view != null && b(view, i2, z) && ci(view.getContext());
    }

    private static boolean b(View view, int i2, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity dj = com.kwad.sdk.j.k.dj(view.getContext());
        if ((dj != null && dj.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z && !view.hasWindowFocus())) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            long height = r9.height() * r9.width();
            long height2 = view.getHeight() * view.getWidth();
            if (height2 > 0 && height * 100 >= i2 * height2) {
                return true;
            }
        }
        return false;
    }

    private static boolean ci(Context context) {
        return an.DN().ci(context);
    }

    public static boolean o(View view, int i2) {
        return view != null && b(view, i2, true) && view.hasWindowFocus() && ci(view.getContext());
    }
}
