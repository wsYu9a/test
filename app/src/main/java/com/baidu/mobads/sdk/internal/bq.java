package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class bq {

    /* renamed from: a */
    public static final String f5638a = "logger";

    /* renamed from: b */
    public static final int f5639b = 2;

    /* renamed from: c */
    public static final int f5640c = 3;

    /* renamed from: d */
    public static final int f5641d = 4;

    /* renamed from: e */
    public static final int f5642e = 5;

    /* renamed from: f */
    public static final int f5643f = 6;

    /* renamed from: g */
    public static final int f5644g = 7;

    /* renamed from: h */
    public static final int f5645h = -1;

    /* renamed from: i */
    private static volatile bq f5646i;

    private bq() {
    }

    public static bq a() {
        if (f5646i == null) {
            synchronized (bq.class) {
                if (f5646i == null) {
                    f5646i = new bq();
                }
            }
        }
        return f5646i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public boolean a(String str, int i2) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                av.c().e(str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(String str) {
        b(f5638a, str);
    }

    public void d(Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }

    public void b(Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(String str) {
        if (a(6)) {
            try {
                av.c().f(str);
            } catch (Exception unused) {
            }
        }
    }

    public void d(String str, Throwable th) {
        if (a(4)) {
            try {
                av.c().c(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, Throwable th) {
        if (a(5)) {
            try {
                av.c().d(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(String str, Throwable th) {
        if (a(6)) {
            try {
                av.c().e(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(int i2) {
        return a(f5638a, i2);
    }

    public void b(Throwable th) {
        b("", th);
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                av.c().c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        a(f5638a, str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                av.h(str).c(str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(String str, Throwable th) {
        if (a(3)) {
            try {
                av.h(f5638a).b(th, str);
            } catch (Exception unused) {
            }
        }
    }
}
