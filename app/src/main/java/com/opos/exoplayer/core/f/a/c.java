package com.opos.exoplayer.core.f.a;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static final int f18605a = u.f("GA94");

    /* renamed from: b */
    private static final int f18606b = u.f("DTG1");

    private static int a(m mVar) {
        int i2 = 0;
        while (mVar.b() != 0) {
            int g2 = mVar.g();
            i2 += g2;
            if (g2 != 255) {
                return i2;
            }
        }
        return -1;
    }

    public static void a(long j2, m mVar, n[] nVarArr) {
        int c2;
        while (mVar.b() > 1) {
            int a2 = a(mVar);
            int a3 = a(mVar);
            int d2 = mVar.d();
            if (a3 == -1 || a3 > mVar.b()) {
                com.opos.cmn.an.f.a.c("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                c2 = mVar.c();
            } else {
                if (a2 == 4 && a3 >= 8) {
                    int g2 = mVar.g();
                    int h2 = mVar.h();
                    int o = h2 == 49 ? mVar.o() : 0;
                    int g3 = mVar.g();
                    if (h2 == 47) {
                        mVar.d(1);
                    }
                    boolean z = g2 == 181 && (h2 == 49 || h2 == 47) && g3 == 3;
                    if (h2 == 49) {
                        z &= o == f18605a || o == f18606b;
                    }
                    if (z) {
                        int g4 = mVar.g();
                        mVar.d(1);
                        int i2 = (g4 & 31) * 3;
                        int d3 = mVar.d();
                        for (n nVar : nVarArr) {
                            mVar.c(d3);
                            nVar.a(mVar, i2);
                            nVar.a(j2, 1, i2, 0, null);
                        }
                    }
                }
                c2 = d2 + a3;
            }
            mVar.c(c2);
        }
    }
}
