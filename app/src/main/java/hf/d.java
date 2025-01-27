package hf;

import android.util.Log;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    public static final String f26691a = "%1$s\n%2$s";

    /* renamed from: b */
    public static volatile boolean f26692b = false;

    /* renamed from: c */
    public static volatile boolean f26693c = true;

    public static void a(String str, Object... objArr) {
        if (f26692b) {
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

    public static void d(Throwable th2) {
        h(6, th2, null, new Object[0]);
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        h(6, th2, str, objArr);
    }

    @Deprecated
    public static void f() {
        k(true);
    }

    public static void g(String str, Object... objArr) {
        h(4, null, str, objArr);
    }

    public static void h(int i10, Throwable th2, String str, Object... objArr) {
        if (f26693c) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th2 != null) {
                if (str == null) {
                    str = th2.getMessage();
                }
                str = String.format(f26691a, str, Log.getStackTraceString(th2));
            }
            Log.println(i10, com.nostra13.universalimageloader.core.b.f16340d, str);
        }
    }

    public static void i(String str, Object... objArr) {
        h(5, null, str, objArr);
    }

    public static void j(boolean z10) {
        f26692b = z10;
    }

    public static void k(boolean z10) {
        f26693c = z10;
    }
}
