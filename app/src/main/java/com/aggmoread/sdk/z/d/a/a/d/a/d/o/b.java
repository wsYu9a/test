package com.aggmoread.sdk.z.d.a.a.d.a.d.o;

import com.aggmoread.sdk.z.d.a.a.d.a.d.l;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.m;
import java.util.Map;

/* loaded from: classes.dex */
public class b extends l {

    /* renamed from: a */
    private static b f5393a;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f5393a == null) {
                    synchronized (b.class) {
                        try {
                            if (f5393a == null) {
                                f5393a = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = f5393a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public static void b(Map<String, Object> map, int i10, e eVar) {
        a().a(map, i10, eVar);
    }

    public static boolean a(e eVar) {
        int b10;
        try {
            b10 = eVar.f5908d.b(e.c.f5948x);
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("test err " + e10);
        }
        if (j.f6028r.booleanValue()) {
            return b10 == 1;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("deg ");
        return false;
    }

    public static boolean a(e eVar, int i10) {
        return m.a(eVar, i10);
    }
}
