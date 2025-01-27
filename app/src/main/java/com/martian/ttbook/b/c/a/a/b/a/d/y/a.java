package com.martian.ttbook.b.c.a.a.b.a.d.y;

import com.cdo.oaps.ad.OapsKey;
import com.martian.ttbook.b.c.a.a.b.a.d.m;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.i;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends m {

    /* renamed from: a */
    private static a f15485a;

    private a() {
    }

    public static int b(Object obj) {
        int i2 = -1;
        try {
            Object invoke = obj.getClass().getMethod("getMediaExtraInfo", new Class[0]).invoke(obj, new Object[0]);
            int intValue = invoke instanceof Map ? ((Integer) ((Map) invoke).get(OapsKey.KEY_PRICE)).intValue() : -1;
            if (intValue < 0) {
                try {
                    d.a("csj c -1 ");
                } catch (Exception e2) {
                    i2 = intValue;
                    e = e2;
                    d.a("csj c err " + e);
                    d.a("csj ecpm  " + i2);
                    return i2;
                }
            } else {
                i2 = intValue;
            }
        } catch (Exception e3) {
            e = e3;
        }
        d.a("csj ecpm  " + i2);
        return i2;
    }

    private static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f15485a == null) {
                synchronized (a.class) {
                    if (f15485a == null) {
                        f15485a = new a();
                    }
                }
            }
            aVar = f15485a;
        }
        return aVar;
    }

    public static void d(Map<String, Object> map, Object obj, e eVar) {
        c().a(map, b(obj), eVar);
    }

    public static boolean e(e eVar) {
        return false;
    }

    public static boolean f(e eVar, Object obj) {
        int b2;
        if (e(eVar) && (b2 = b(obj)) >= 0) {
            return i.h(eVar, b2);
        }
        return false;
    }
}
