package com.opos.mobad.a;

import android.content.Context;
import com.opos.mobad.model.e.a;

/* loaded from: classes4.dex */
public class e {
    public static final com.opos.mobad.n.a a(Context context, a.C0457a c0457a) {
        if (c0457a == null) {
            return null;
        }
        com.opos.mobad.n.a a2 = com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), c0457a.f21745c.b(), c0457a.f21744b.P(), null);
        if (a2 == null) {
            int i2 = 0;
            int d2 = c0457a.f21745c.d();
            if (d2 == 2) {
                i2 = 2;
            } else if (d2 == 3) {
                i2 = 1;
            } else if (d2 == 6) {
                i2 = 3;
            } else if (d2 == 7) {
                i2 = 4;
            } else if (d2 == 8) {
                i2 = 53;
            }
            a2 = com.opos.mobad.o.e.b.a().a(context.getApplicationContext(), i2, c0457a.f21744b.P(), null);
        }
        if (a2 != null) {
            return new com.opos.mobad.a.a.a(context.getApplicationContext(), a2);
        }
        return null;
    }
}
