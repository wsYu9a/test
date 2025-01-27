package com.aggmoread.sdk.z.d.a.a.d.a.d.w;

import com.aggmoread.sdk.z.d.a.a.d.a.d.l;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends l {

    /* renamed from: a */
    private static a f5815a;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f5815a == null) {
                    synchronized (a.class) {
                        try {
                            if (f5815a == null) {
                                f5815a = new a();
                            }
                        } finally {
                        }
                    }
                }
                aVar = f5815a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public static void b(Map<String, Object> map, int i10, e eVar) {
        a().a(map, i10, eVar);
    }

    public static boolean a(e eVar, int i10) {
        return m.a(eVar, i10);
    }
}
