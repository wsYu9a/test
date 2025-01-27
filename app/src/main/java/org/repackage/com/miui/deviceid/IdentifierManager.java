package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class IdentifierManager {

    /* renamed from: a */
    private static final String f35582a = "IdentifierManager";

    /* renamed from: b */
    private static Object f35583b;

    /* renamed from: c */
    private static Class<?> f35584c;

    /* renamed from: d */
    private static Method f35585d;

    /* renamed from: e */
    private static Method f35586e;

    /* renamed from: f */
    private static Method f35587f;

    /* renamed from: g */
    private static Method f35588g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f35584c = cls;
            f35583b = cls.newInstance();
            f35585d = f35584c.getMethod("getUDID", Context.class);
            f35586e = f35584c.getMethod("getOAID", Context.class);
            f35587f = f35584c.getMethod("getVAID", Context.class);
            f35588g = f35584c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e(f35582a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (f35584c == null || f35583b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f35586e);
    }

    public static String c(Context context) {
        return a(context, f35587f);
    }

    public static String d(Context context) {
        return a(context, f35588g);
    }

    public static String a(Context context) {
        return a(context, f35585d);
    }

    private static String a(Context context, Method method) {
        Object obj = f35583b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(f35582a, "invoke exception!", e2);
            return null;
        }
    }
}
