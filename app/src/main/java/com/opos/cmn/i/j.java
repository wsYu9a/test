package com.opos.cmn.i;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.PowerManager;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private static final String f17433a = "j";

    private static final RectF a(View view) {
        RectF rectF;
        try {
            view.getLocationOnScreen(new int[]{-1, -1});
            rectF = new RectF(r0[0], r0[1], r0[0] + view.getWidth(), r0[1] + view.getHeight());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a(f17433a, "", (Throwable) e2);
            rectF = null;
        }
        String str = f17433a;
        StringBuilder sb = new StringBuilder();
        sb.append("getViewScreenLocation=");
        sb.append(rectF != null ? rectF.toString() : "null");
        com.opos.cmn.an.f.a.b(str, sb.toString());
        return rectF;
    }

    public static final boolean a(Context context) {
        if (context != null) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                r0 = powerManager != null ? Build.VERSION.SDK_INT >= 20 ? powerManager.isInteractive() : powerManager.isScreenOn() : true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a(f17433a, "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b(f17433a, "is screenOn = " + r0);
        return r0;
    }

    public static final boolean a(Context context, View view) {
        if (context == null || view == null || !view.isInTouchMode()) {
            return false;
        }
        if (!view.isShown()) {
            com.opos.cmn.an.f.a.b(f17433a, "view not shown");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return b(view);
        }
        if (!com.opos.cmn.an.h.d.a.a(context, view)) {
            return false;
        }
        RectF rectF = null;
        int j2 = com.opos.cmn.an.h.f.a.j(context);
        if (j2 == 0) {
            rectF = new RectF(0.0f, 0.0f, com.opos.cmn.an.h.f.a.b(context), 79.0f);
        } else if (j2 == 90) {
            rectF = new RectF(0.0f, 0.0f, 79.0f, com.opos.cmn.an.h.f.a.b(context));
        } else if (j2 == 180) {
            rectF = new RectF(0.0f, com.opos.cmn.an.h.f.a.c(context) - 79.0f, com.opos.cmn.an.h.f.a.b(context), com.opos.cmn.an.h.f.a.c(context));
        } else if (j2 == 270) {
            rectF = new RectF(com.opos.cmn.an.h.f.a.c(context) - 79.0f, 0.0f, com.opos.cmn.an.h.f.a.c(context), com.opos.cmn.an.h.f.a.b(context));
        }
        return a(rectF, view);
    }

    public static final boolean a(RectF rectF, View view) {
        boolean z;
        RectF a2;
        if (view != null && rectF != null) {
            try {
                a2 = a(view);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a(f17433a, "", (Throwable) e2);
            }
            if (a2 != null) {
                if (RectF.intersects(rectF, a2)) {
                    z = true;
                    com.opos.cmn.an.f.a.b(f17433a, "isCoodinateInRect rect=" + rectF + ",view =" + view);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b(f17433a, "isCoodinateInRect rect=" + rectF + ",view =" + view);
        return z;
    }

    @TargetApi(28)
    private static final boolean b(View view) {
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || (boundingRects = displayCutout.getBoundingRects()) == null || boundingRects.size() <= 0) {
            return false;
        }
        Iterator<Rect> it = boundingRects.iterator();
        while (it.hasNext()) {
            if (a(new RectF(it.next()), view)) {
                return true;
            }
        }
        return false;
    }
}
