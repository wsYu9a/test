package com.baidu.mobads.sdk.internal;

/* loaded from: classes2.dex */
public class bt {

    /* renamed from: a */
    public static final String f6951a = "logger";

    /* renamed from: b */
    public static final int f6952b = 2;

    /* renamed from: c */
    public static final int f6953c = 3;

    /* renamed from: d */
    public static final int f6954d = 4;

    /* renamed from: e */
    public static final int f6955e = 5;

    /* renamed from: f */
    public static final int f6956f = 6;

    /* renamed from: g */
    public static final int f6957g = 7;

    /* renamed from: h */
    public static final int f6958h = -1;

    /* renamed from: i */
    private static volatile bt f6959i;

    private bt() {
    }

    private String e(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            sb2.append(obj);
            sb2.append(b5.a.O);
        }
        return sb2.toString();
    }

    public boolean a(String str, int i10) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                ay.c().e(str);
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
        b(f6951a, str);
    }

    public static bt a() {
        if (f6959i == null) {
            synchronized (bt.class) {
                try {
                    if (f6959i == null) {
                        f6959i = new bt();
                    }
                } finally {
                }
            }
        }
        return f6959i;
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
                ay.c().f(str);
            } catch (Exception unused) {
            }
        }
    }

    public void d(String str, Throwable th2) {
        if (a(4)) {
            try {
                ay.c().c(th2, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, Throwable th2) {
        if (a(5)) {
            try {
                ay.c().d(th2, str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Throwable th2) {
        c("", th2);
    }

    public void c(String str, Throwable th2) {
        if (a(6)) {
            try {
                ay.c().e(th2, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(Throwable th2) {
        b("", th2);
    }

    public boolean a(int i10) {
        return a(f6951a, i10);
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                ay.c().c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public void a(String str) {
        a(f6951a, str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                ay.h(str).c(str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Throwable th2) {
        a("", th2);
    }

    public void a(String str, Throwable th2) {
        if (a(3)) {
            try {
                ay.h(f6951a).b(th2, str);
            } catch (Exception unused) {
            }
        }
    }
}
