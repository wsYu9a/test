package com.martian.ttbook.b.c.a.a.d.a.d.x;

import com.martian.ttbook.b.c.a.a.b.a.d.m;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.i;
import java.util.Map;

/* loaded from: classes4.dex */
public class c extends m {

    /* renamed from: a */
    private static c f15604a;

    private c() {
    }

    public static int b(Object obj) {
        return d.a(obj);
    }

    private static synchronized c c() {
        c cVar;
        synchronized (c.class) {
            if (f15604a == null) {
                synchronized (c.class) {
                    if (f15604a == null) {
                        f15604a = new c();
                    }
                }
            }
            cVar = f15604a;
        }
        return cVar;
    }

    public static void d(Map<String, Object> map, Object obj, e eVar) {
        if (map != null) {
            c().a(map, b(obj), eVar);
        }
    }

    public static boolean e(e eVar, int i2) {
        if (i2 < 0) {
            return false;
        }
        return i.h(eVar, i2);
    }

    public static boolean f(e eVar, Object obj) {
        return e(eVar, b(obj));
    }
}
