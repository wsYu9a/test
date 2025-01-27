package com.vivo.mobilead.util;

import android.view.View;

/* loaded from: classes4.dex */
public class e {
    private static int a(int i2, int i3) {
        return (i2 >> (i3 - 1)) & 1;
    }

    public static boolean a(boolean z, com.vivo.ad.model.b bVar) {
        return (bVar == null || bVar.l() != 2) ? z ? a(bVar, 9) : a(bVar, 8) : b(z, bVar);
    }

    public static boolean b(com.vivo.ad.model.b bVar) {
        return a(bVar, 8);
    }

    public static boolean c(com.vivo.ad.model.b bVar) {
        return a(bVar, 9);
    }

    public static boolean d(com.vivo.ad.model.b bVar) {
        return a(bVar, 1);
    }

    public static boolean e(com.vivo.ad.model.b bVar) {
        return a(bVar, 2);
    }

    public static boolean f(com.vivo.ad.model.b bVar) {
        return a(bVar, 6);
    }

    public static boolean g(com.vivo.ad.model.b bVar) {
        return a(bVar, 3);
    }

    public static boolean h(com.vivo.ad.model.b bVar) {
        return a(bVar, 4);
    }

    public static boolean i(com.vivo.ad.model.b bVar) {
        return a(bVar, 7);
    }

    public static boolean j(com.vivo.ad.model.b bVar) {
        return a(bVar, 5);
    }

    public static boolean b(boolean z, com.vivo.ad.model.b bVar) {
        if (bVar == null || bVar.y() == null) {
            return false;
        }
        return z ? a(bVar, 9, false) : a(bVar, 8, false);
    }

    public static boolean a(View view, com.vivo.ad.model.b bVar) {
        if (view == null) {
            return true;
        }
        if (view.getTag() instanceof Integer) {
            return a(bVar, ((Integer) view.getTag()).intValue());
        }
        return a(view instanceof com.vivo.ad.view.a, bVar);
    }

    public static boolean a(com.vivo.ad.model.b bVar, int i2) {
        return a(bVar, i2, true);
    }

    public static boolean a(com.vivo.ad.model.b bVar, int i2, boolean z) {
        return (a(bVar) || bVar.y() == null) ? z : a(bVar.y().i(), i2) == 1;
    }

    public static boolean a(com.vivo.ad.model.b bVar) {
        return bVar == null || bVar.y() == null;
    }
}
