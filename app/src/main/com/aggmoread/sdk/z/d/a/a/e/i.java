package com.aggmoread.sdk.z.d.a.a.e;

import java.util.Random;

/* loaded from: classes.dex */
public final class i {
    public static int a(int i10, int i11) {
        if (i10 >= i11) {
            return i11;
        }
        int nextInt = new Random().nextInt((i11 - i10) + 1) + i10;
        e.a("AMGTAG", "ni %s", Integer.valueOf(nextInt));
        return nextInt;
    }

    public static boolean a(double d10) {
        if (d10 > l5.c.f27899e) {
            int a10 = a(0, 10000);
            e.a("AMGTAG", "rn %s, v %s", Integer.valueOf(a10), Double.valueOf(d10));
            if (a10 <= Math.floor(d10 * 10000.0d)) {
                return true;
            }
        }
        return false;
    }
}
