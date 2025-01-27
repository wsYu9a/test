package com.martian.ttbook.b.c.a.a.e;

import java.util.Random;

/* loaded from: classes4.dex */
public final class g {
    public static int a(int i2, int i3) {
        if (i2 >= i3) {
            return i3;
        }
        int nextInt = new Random().nextInt((i3 - i2) + 1) + i2;
        d.c("ADGLOBALTAG", "ni %s", Integer.valueOf(nextInt));
        return nextInt;
    }

    public static boolean b(double d2) {
        if (d2 > 0.0d) {
            int a2 = a(0, 10000);
            d.c("ADGLOBALTAG", "rn %s, v %s", Integer.valueOf(a2), Double.valueOf(d2));
            if (a2 <= Math.floor(d2 * 10000.0d)) {
                return true;
            }
        }
        return false;
    }
}
