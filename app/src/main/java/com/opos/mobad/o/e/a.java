package com.opos.mobad.o.e;

import android.content.Context;
import com.opos.mobad.n.e.h;

/* loaded from: classes4.dex */
public class a {
    public static int a(int i2) {
        return com.opos.mobad.service.c.b.a().c(i2);
    }

    public static com.opos.mobad.n.a a(Context context, int i2, int i3) {
        if (a(i2) == 0) {
            return i3 == 1 ? new h(context, i2) : new com.opos.mobad.n.e.a(context, i2);
        }
        return null;
    }
}
