package s2;

import android.content.Context;
import d2.b;
import d2.d;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        if (b.f25228a) {
            return d.b.f25236a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean b() {
        if (b.f25228a) {
            return b.f25229b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (b.f25228a) {
            return d.b.f25236a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (b.f25228a) {
            return d.b.f25236a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (b.f25228a) {
            return d.b.f25236a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void f(Context context) {
        b.f25229b = d.b.f25236a.b(context.getApplicationContext());
        b.f25228a = true;
    }
}
