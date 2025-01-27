package com.martian.ttbook.b.c.a.a;

import android.content.Context;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static boolean f15206a = false;

    /* renamed from: b */
    private static boolean f15207b = false;

    /* renamed from: c */
    private static final LinkedBlockingDeque<Object[]> f15208c = new LinkedBlockingDeque<>();

    /* renamed from: d */
    public static Object[] f15209d = {null, null, null, null, null, null, Collections.synchronizedMap(new HashMap()), Collections.synchronizedMap(new WeakHashMap())};

    public static class a {
        public static native Object b(int i2, Object obj);
    }

    public static void A(String str) {
        a.b(12, new Object[]{new int[]{12}, str});
    }

    public static void B(String str) {
        a.b(12, new Object[]{new int[]{13}, str});
    }

    public static void C(String str) {
        a.b(12, new Object[]{new int[]{14}, str});
    }

    public static void D(String str) {
        a.b(12, new Object[]{new int[]{15}, str});
    }

    public static void E(String str) {
        a.b(12, new Object[]{new int[]{2}, str});
    }

    public static void F(String str) {
        a.b(12, new Object[]{new int[]{3}, str});
    }

    public static void G(String str) {
        a.b(12, new Object[]{new int[]{4}, str});
    }

    public static void H(String str) {
        a.b(12, new Object[]{new int[]{5}, str});
    }

    public static void I(String str) {
        a.b(12, new Object[]{new int[]{6}, str});
    }

    public static void J(String str) {
        a.b(12, new Object[]{new int[]{7}, str});
    }

    public static void K(String str) {
        a.b(12, new Object[]{new int[]{8}, str});
    }

    public static void L(String str) {
        a.b(12, new Object[]{new int[]{9}, str});
    }

    public static int a(byte[] bArr) {
        return ((int[]) a.b(14, bArr))[0];
    }

    public static Object b(int i2, int i3) {
        return a.b(1, new int[]{i2, i3});
    }

    public static Object c(String str, int[] iArr) {
        return a.b(2, new Object[]{str, iArr});
    }

    public static String d(Object obj) {
        return (String) a.b(10, obj);
    }

    public static void e() {
        if (f15206a) {
            return;
        }
        synchronized (b.class) {
            if (!f15206a) {
                try {
                    System.setProperty("JHNAME", a.class.getName());
                    System.getSecurityManager();
                    System.loadLibrary("sdkcore");
                    f15206a = ((Boolean) a.b(0, Boolean.TRUE)).booleanValue();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void f(Object[] objArr) {
        a.b(4, objArr);
    }

    public static void g(Object[] objArr, Context context) {
        if (f15207b) {
            f15208c.offer(objArr);
        }
    }

    public static boolean h(Context context, boolean z) {
        if (f15207b) {
            return true;
        }
        synchronized (b.class) {
            if (f15207b) {
                return true;
            }
            boolean z2 = ((boolean[]) a.b(11, new Object[]{context, f15208c, new int[]{5, 1, 3, 4, 2, 0, 6, 7, 8, 9}, f15209d, new boolean[]{z}}))[0];
            f15207b = z2;
            return z2;
        }
    }

    public static byte[] i(String str) {
        return (byte[]) a.b(3, str);
    }

    public static byte[] j(int[] iArr) {
        return (byte[]) a.b(13, iArr);
    }

    public static String k(Object obj) {
        return (String) a.b(15, obj);
    }

    public static Map<Object, Object> l(String str) {
        return (Map) a.b(9, str);
    }

    public static void m(Object[] objArr) {
        a.b(5, objArr);
    }

    public static Object[] n() {
        Object[] objArr = {null, null, null, null, null, null, null, null, null, null};
        objArr[8] = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        return objArr;
    }

    public static String o(Object obj) {
        return (String) a.b(17, obj);
    }

    public static Map<Object, Object> p(String str) {
        return (Map) a.b(16, str);
    }

    public static void q() {
        a.b(19, null);
    }

    public static void r(Object[] objArr) {
        a.b(6, objArr);
    }

    public static Map<Object, Object> s(String str) {
        return (Map) a.b(18, str);
    }

    public static void t(Object[] objArr) {
        a.b(7, objArr);
    }

    public static void u(String str) {
        a.b(12, new Object[]{new int[]{0}, str});
    }

    public static void v(Object[] objArr) {
        a.b(20, objArr);
    }

    public static void w(String str) {
        a.b(12, new Object[]{new int[]{1}, str});
    }

    public static void x(Object[] objArr) {
        a.b(8, objArr);
    }

    public static void y(String str) {
        a.b(12, new Object[]{new int[]{10}, str});
    }

    public static void z(String str) {
        a.b(12, new Object[]{new int[]{11}, str});
    }
}
