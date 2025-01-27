package u2;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final String f30924a = "OpenIdHelper";

    /* renamed from: b */
    public static Method f30925b;

    public static String a(Context context) {
        e d10 = e.d();
        return d10.a(context.getApplicationContext(), d10.f30935c);
    }

    public static void b(boolean z10) {
        e.d();
        e.f(z10);
    }

    public static final boolean c() {
        Context context = null;
        try {
            if (f30925b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                f30925b = method;
                method.setAccessible(true);
            }
            context = (Context) f30925b.invoke(null, null);
        } catch (Exception e10) {
            Log.e(f30924a, "ActivityThread:currentApplication --> " + e10.toString());
        }
        if (context == null) {
            return false;
        }
        return e.d().h(context, false);
    }

    public static String d(Context context) {
        e d10 = e.d();
        return d10.a(context.getApplicationContext(), d10.f30934b);
    }

    public static String e(Context context) {
        e d10 = e.d();
        return d10.a(context.getApplicationContext(), d10.f30933a);
    }

    public static String f(Context context) {
        e d10 = e.d();
        return d10.a(context.getApplicationContext(), d10.f30936d);
    }
}
