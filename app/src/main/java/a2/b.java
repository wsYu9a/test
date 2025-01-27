package a2;

import android.content.Context;

/* loaded from: classes.dex */
public class b extends u3.b {
    public static void d(Context context) {
        u3.b.d(context);
    }

    public static String e(Context context) {
        return u3.b.e(context);
    }

    public static String f(Context context) {
        return u3.b.f(context);
    }

    public static synchronized String g(Context context) {
        String g10;
        synchronized (b.class) {
            g10 = u3.b.g(context);
        }
        return g10;
    }

    public static String h(Context context) {
        return u3.b.h(context);
    }

    public static String i(Context context) {
        return u3.b.i(context);
    }

    public static boolean m(Context context) throws Exception {
        return u3.b.m(context);
    }

    public static a n(Context context) {
        return a.e(u3.b.j(context));
    }

    public static synchronized a o(Context context) {
        a e10;
        synchronized (b.class) {
            e10 = a.e(u3.b.k(context));
        }
        return e10;
    }

    public static a p(Context context) {
        return a.e(u3.b.l(context));
    }
}
