package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile boolean f24250a = true;

    /* renamed from: b */
    private static volatile boolean f24251b = true;

    /* renamed from: c */
    private static volatile boolean f24252c = true;

    /* renamed from: d */
    private static volatile boolean f24253d = true;

    /* renamed from: e */
    private static volatile boolean f24254e = true;

    /* renamed from: g */
    private static Map<String, Boolean> f24256g = new HashMap();

    /* renamed from: f */
    private static Object f24255f = new Object();

    public static boolean a() {
        boolean z10;
        synchronized (f24255f) {
            z10 = f24250a;
        }
        return z10;
    }

    public static boolean b() {
        boolean z10;
        synchronized (f24255f) {
            z10 = f24251b;
        }
        return z10;
    }

    public static boolean c() {
        boolean z10;
        synchronized (f24255f) {
            z10 = f24252c;
        }
        return z10;
    }

    public static boolean d() {
        boolean z10;
        synchronized (f24255f) {
            z10 = f24253d;
        }
        return z10;
    }

    public static void a(boolean z10) {
        synchronized (f24255f) {
            f24253d = z10;
            f24256g.put(a.f24228e, Boolean.valueOf(z10));
        }
    }

    public static void b(boolean z10) {
        synchronized (f24255f) {
            f24254e = z10;
            f24256g.put(a.f24232i, Boolean.valueOf(z10));
        }
    }

    public static boolean a(String str) {
        boolean booleanValue;
        synchronized (f24255f) {
            try {
                booleanValue = f24256g.containsKey(str) ? f24256g.get(str).booleanValue() : true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return booleanValue;
    }
}
