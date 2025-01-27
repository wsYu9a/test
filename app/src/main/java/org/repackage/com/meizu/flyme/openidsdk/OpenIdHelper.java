package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class OpenIdHelper {

    /* renamed from: a */
    private static final String f29371a = "OpenIdHelper";

    /* renamed from: b */
    private static Method f29372b;

    public static String a(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f29380a);
    }

    public static String b(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f29381b);
    }

    public static String c(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f29383d);
    }

    public static String d(Context context) {
        b a10 = b.a();
        return a10.a(context.getApplicationContext(), a10.f29382c);
    }

    public static void a(boolean z10) {
        b.a();
        b.a(z10);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f29372b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                f29372b = method;
                method.setAccessible(true);
            }
            context = (Context) f29372b.invoke(null, null);
        } catch (Exception e10) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e10.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }
}
