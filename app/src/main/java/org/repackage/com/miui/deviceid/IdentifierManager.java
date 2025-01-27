package org.repackage.com.miui.deviceid;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class IdentifierManager {

    /* renamed from: a */
    private static final String f29392a = "IdentifierManager";

    /* renamed from: b */
    private static Object f29393b;

    /* renamed from: c */
    private static Class<?> f29394c;

    /* renamed from: d */
    private static Method f29395d;

    /* renamed from: e */
    private static Method f29396e;

    /* renamed from: f */
    private static Method f29397f;

    /* renamed from: g */
    private static Method f29398g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f29394c = cls;
            f29393b = cls.newInstance();
            f29395d = f29394c.getMethod("getUDID", Context.class);
            f29396e = f29394c.getMethod("getOAID", Context.class);
            f29397f = f29394c.getMethod("getVAID", Context.class);
            f29398g = f29394c.getMethod("getAAID", Context.class);
        } catch (Exception e10) {
            Log.e("IdentifierManager", "reflect exception!", e10);
        }
    }

    public static boolean a() {
        return (f29394c == null || f29393b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f29396e);
    }

    public static String c(Context context) {
        return a(context, f29397f);
    }

    public static String d(Context context) {
        return a(context, f29398g);
    }

    public static String a(Context context) {
        return a(context, f29395d);
    }

    private static String a(Context context, Method method) {
        Object obj = f29393b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e10) {
            Log.e("IdentifierManager", "invoke exception!", e10);
            return null;
        }
    }
}
