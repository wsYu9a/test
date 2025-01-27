package com.martian.ttbook.b.c.a.a.b.a.d.x;

import android.text.TextUtils;
import com.martian.ttbook.b.c.a.a.b.a.d.m;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.e.d;
import com.martian.ttbook.b.c.a.a.e.i;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends m {

    /* renamed from: a */
    private static a f15437a;

    private a() {
    }

    public static int b(Object obj) {
        Exception e2;
        int i2;
        String str;
        int i3 = -1;
        try {
            Method method = obj.getClass().getMethod("getECPMLevel", new Class[0]);
            method.setAccessible(true);
            str = (String) method.invoke(obj, new Object[0]);
        } catch (Exception e3) {
            e2 = e3;
            i2 = -1;
        }
        if (!TextUtils.isEmpty(str)) {
            i2 = Integer.valueOf(str).intValue();
            if (i2 <= 0) {
                try {
                    d.a("bd c -1 ");
                } catch (Exception e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    d.a("bd ecpm err " + e2.getMessage());
                    i3 = i2;
                    d.a("bd ecpm " + i3);
                    return i3;
                }
            }
            i3 = i2;
        }
        d.a("bd ecpm " + i3);
        return i3;
    }

    private static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f15437a == null) {
                synchronized (a.class) {
                    if (f15437a == null) {
                        f15437a = new a();
                    }
                }
            }
            aVar = f15437a;
        }
        return aVar;
    }

    public static void d(Object obj, int i2) {
        try {
            obj.getClass().getDeclaredMethod("biddingSuccess", String.class).invoke(obj, String.valueOf(i2));
            d.a("bd send sus " + i2);
        } catch (Exception e2) {
            d.a("bd send sus err " + e2);
        }
    }

    public static void e(Object obj, String str) {
        try {
            obj.getClass().getDeclaredMethod("biddingFail", String.class).invoke(obj, str);
            d.a("bd send fail " + str);
        } catch (Exception e2) {
            d.a("bd send fail err " + e2);
        }
    }

    public static boolean f(e eVar, int i2) {
        if (i2 < 0) {
            return false;
        }
        return i.h(eVar, i2);
    }

    public static void g(Map<String, Object> map, int i2, e eVar) {
        c().a(map, i2, eVar);
    }
}
