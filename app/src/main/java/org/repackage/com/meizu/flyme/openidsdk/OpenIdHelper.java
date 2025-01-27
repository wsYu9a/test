package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class OpenIdHelper {

    /* renamed from: a */
    private static final String f35561a = "OpenIdHelper";

    /* renamed from: b */
    private static Method f35562b;

    public static String a(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f35570a);
    }

    public static void a(boolean z) {
        b.a();
        b.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f35562b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f35562b = method;
                method.setAccessible(true);
            }
            context = (Context) f35562b.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e(f35561a, "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static String b(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f35571b);
    }

    public static String c(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f35573d);
    }

    public static String d(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f35572c);
    }
}
