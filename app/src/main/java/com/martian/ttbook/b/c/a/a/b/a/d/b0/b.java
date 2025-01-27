package com.martian.ttbook.b.c.a.a.b.a.d.b0;

import com.martian.ttbook.b.c.a.a.b.a.d.m;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.i;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes4.dex */
public class b extends m {

    /* renamed from: a */
    private static b f15316a;

    private b() {
    }

    public static int b(Object obj) {
        Exception e2;
        int i2;
        try {
            Method method = obj.getClass().getMethod("getECPM", new Class[0]);
            method.setAccessible(true);
            i2 = ((Integer) method.invoke(obj, new Object[0])).intValue();
            if (i2 <= 0) {
                try {
                    d.a("c -1 ");
                    return -1;
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    d.a("ks ecpm err " + e2.getMessage());
                    return i2;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            i2 = -1;
        }
        return i2;
    }

    private static synchronized b c() {
        b bVar;
        synchronized (b.class) {
            if (f15316a == null) {
                synchronized (b.class) {
                    if (f15316a == null) {
                        f15316a = new b();
                    }
                }
            }
            bVar = f15316a;
        }
        return bVar;
    }

    private static Object d(Object obj, String str, Object[] objArr, Class... clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception e2) {
            d.a("ks invoke method failed,  method " + str + ", err " + e2.getMessage());
            return null;
        }
    }

    public static void e(Object obj, int i2) {
        try {
            Object obj2 = Class.forName("com.kwad.sdk.api.model.AdExposureFailureCode").getDeclaredField("BID_FAILED").get(null);
            Class<?> cls = Class.forName("com.kwad.sdk.api.model.AdExposureFailedReason");
            Object newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            cls.getField("winEcpm").setInt(newInstance, i2);
            d(obj, "reportAdExposureFailed", new Object[]{obj2, newInstance}, Integer.TYPE, cls);
            d.a("ks send failed end");
        } catch (Exception e2) {
            d.a("ks send failed err " + e2.getMessage());
        }
    }

    public static boolean f(e eVar, int i2) {
        if (i2 <= 0) {
            return false;
        }
        return i.h(eVar, i2);
    }

    public static void g(Object obj, int i2) {
        d(obj, "setBidEcpm", new Object[]{Integer.valueOf(i2)}, Integer.TYPE);
        d.a("ks send success end");
    }

    public static void h(Map<String, Object> map, int i2, e eVar) {
        c().a(map, i2, eVar);
    }
}
