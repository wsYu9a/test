package b.g.a.b;

import android.util.Log;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static final String f4916a = "%1$s\n%2$s";

    /* renamed from: b */
    private static volatile boolean f4917b = false;

    /* renamed from: c */
    private static volatile boolean f4918c = true;

    private d() {
    }

    public static void a(String str, Object... objArr) {
        if (f4917b) {
            h(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void b() {
        k(false);
    }

    public static void c(String str, Object... objArr) {
        h(6, null, str, objArr);
    }

    public static void d(Throwable th) {
        h(6, th, null, new Object[0]);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        h(6, th, str, objArr);
    }

    @Deprecated
    public static void f() {
        k(true);
    }

    public static void g(String str, Object... objArr) {
        h(4, null, str, objArr);
    }

    private static void h(int i2, Throwable th, String str, Object... objArr) {
        if (f4918c) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format(f4916a, str, Log.getStackTraceString(th));
            }
            Log.println(i2, com.nostra13.universalimageloader.core.d.f15960a, str);
        }
    }

    public static void i(String str, Object... objArr) {
        h(5, null, str, objArr);
    }

    public static void j(boolean z) {
        f4917b = z;
    }

    public static void k(boolean z) {
        f4918c = z;
    }
}
