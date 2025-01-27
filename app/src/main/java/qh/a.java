package qh;

import android.content.Context;
import java.lang.reflect.Method;
import jh.c;
import w2.b;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static Object f30077a;

    /* renamed from: b */
    public static Class<?> f30078b;

    /* renamed from: c */
    public static Method f30079c;

    /* renamed from: d */
    public static Method f30080d;

    /* renamed from: e */
    public static Method f30081e;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f30078b = cls;
            f30077a = cls.newInstance();
        } catch (Exception e10) {
            c.b(b.f31562a, "reflect exception!", e10);
        }
        try {
            Class<?> cls2 = f30078b;
            if (cls2 != null) {
                f30079c = cls2.getMethod("getOAID", Context.class);
            }
        } catch (Exception e11) {
            c.b(b.f31562a, "reflect exception!", e11);
        }
        try {
            Class<?> cls3 = f30078b;
            if (cls3 != null) {
                f30080d = cls3.getMethod("getVAID", Context.class);
            }
        } catch (Exception e12) {
            c.b(b.f31562a, "reflect exception!", e12);
        }
        try {
            Class<?> cls4 = f30078b;
            if (cls4 != null) {
                f30081e = cls4.getMethod("getAAID", Context.class);
            }
        } catch (Exception e13) {
            c.b(b.f31562a, "reflect exception!", e13);
        }
    }

    public static String a(Context context, Method method) {
        Object obj = f30077a;
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
            c.b(b.f31562a, "invoke exception!", e10);
            return null;
        }
    }
}
