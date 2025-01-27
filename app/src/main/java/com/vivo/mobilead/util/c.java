package com.vivo.mobilead.util;

import android.view.View;

/* loaded from: classes4.dex */
public class c {
    public static boolean a(com.vivo.ad.model.b bVar) {
        return (bVar == null || bVar.l() != 2) ? a(bVar, 8) : a(bVar, 8, false);
    }

    public static boolean b(com.vivo.ad.model.b bVar) {
        return a(bVar, 1);
    }

    public static boolean c(com.vivo.ad.model.b bVar) {
        return a(bVar, 3);
    }

    public static boolean d(com.vivo.ad.model.b bVar) {
        if (bVar != null) {
            boolean z = bVar.l() == 4 && bVar.Q() != null;
            boolean z2 = bVar.l() == 9;
            if (z || z2) {
                return a(bVar, 7, false);
            }
        }
        return a(bVar, 7);
    }

    public static boolean b(int i2, int i3) {
        return a(i2, i3) != 0;
    }

    private static boolean a(com.vivo.ad.model.b bVar, int i2) {
        return a(bVar, i2, true);
    }

    private static boolean a(com.vivo.ad.model.b bVar, int i2, boolean z) {
        com.vivo.ad.model.e c2;
        return (bVar == null || (c2 = bVar.c()) == null) ? z : b(c2.h(), i2);
    }

    private static int a(int i2, int i3) {
        j.a.b.a("AdClickComplianceUtil", Integer.toBinaryString(i2) + " bit = " + i3);
        return (i2 >> (i3 - 1)) & 1;
    }

    public static boolean a(View view, com.vivo.ad.model.b bVar) {
        boolean c2;
        if (view != null && (view.getTag() instanceof Integer)) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == 8) {
                c2 = a(bVar);
            } else if (intValue == 7) {
                c2 = d(bVar);
            } else if (intValue == 1) {
                c2 = b(bVar);
            } else if (intValue == 3) {
                c2 = c(bVar);
            }
            return !c2;
        }
        return false;
    }
}
