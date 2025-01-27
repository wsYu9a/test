package jh;

import android.util.Log;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: b */
    public static c f27578b;

    /* renamed from: a */
    public int f27579a = -1;

    public static void a(String str, String str2) {
        if (e()) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th2) {
        if (e()) {
            Log.d(str, str2, th2);
        }
    }

    public static void c(Throwable th2) {
        if (e()) {
            Log.e("mdidsdk", "extractor exception!", th2);
        }
    }

    public static void d(boolean z10) {
        f().f27579a = z10 ? 1 : 0;
    }

    public static boolean e() {
        return f().f27579a == 1;
    }

    public static c f() {
        if (f27578b == null) {
            synchronized (c.class) {
                try {
                    if (f27578b == null) {
                        f27578b = new c();
                    }
                } finally {
                }
            }
        }
        return f27578b;
    }

    public static void g(String str, String str2) {
        if (e()) {
            Log.d(str, str2);
        }
    }
}
