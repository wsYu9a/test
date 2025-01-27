package uk;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: a */
    public static final String f31176a = "InstanceCreationUtils";

    /* renamed from: b */
    public static final Class<?>[] f31177b = new Class[0];

    /* renamed from: c */
    public static final Class<?>[] f31178c = new Class[0];

    /* renamed from: d */
    public static final HashMap<Class, Class> f31179d = new HashMap<>();

    static {
        a(xk.a.f32937a, xk.a.class);
        a(xk.b.f32938a, xk.b.class);
        a(xk.d.f32939a, xk.d.class);
    }

    public static void a(Class[] clsArr, Class<?> cls) {
        for (Class cls2 : clsArr) {
            f31179d.put(cls2, cls);
        }
    }

    public static xk.c b(View view) {
        for (Map.Entry<Class, Class> entry : f31179d.entrySet()) {
            if (entry.getKey().isInstance(view)) {
                return (xk.c) e(view.getContext(), entry.getValue(), f31177b, new Object[0]);
            }
        }
        return null;
    }

    public static <T> T c(Context context, String str) {
        try {
            return (T) e(context, context.getClassLoader().loadClass(str), f31178c, new Object[0]);
        } catch (Exception e10) {
            Log.w(f31176a, "Cannot instantiate class: " + str, e10);
            return null;
        }
    }

    public static <T> T d(Context context, String str) {
        try {
            return (T) e(context, context.getClassLoader().loadClass(str), f31177b, new Object[0]);
        } catch (Exception e10) {
            Log.w(f31176a, "Cannot instantiate class: " + str, e10);
            return null;
        }
    }

    public static <T> T e(Context context, Class cls, Class[] clsArr, Object... objArr) {
        try {
            return cls.getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e10) {
            Log.w(f31176a, "Cannot instantiate class: " + cls.getName(), e10);
            return null;
        }
    }
}
