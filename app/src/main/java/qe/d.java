package qe;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a */
    public static final String f30038a = "d";

    /* renamed from: b */
    public static final Object f30039b;

    /* renamed from: c */
    public static final Method f30040c;

    static {
        String simpleName = d.class.getSimpleName();
        Object c10 = c();
        f30039b = c10;
        f30040c = d();
        if (c10 == null) {
            Log.v(simpleName, "This device does supports control of a flashlight");
        } else {
            Log.v(simpleName, "This device does not support control of a flashlight");
        }
    }

    public static void a() {
        h();
    }

    public static void b() {
        h();
    }

    public static Object c() {
        Method g10;
        Object e10;
        Class<?> f10;
        Method g11;
        Class<?> f11 = f("android.os.ServiceManager");
        if (f11 == null || (g10 = g(f11, "getService", String.class)) == null || (e10 = e(g10, null, "hardware")) == null || (f10 = f("android.os.IHardwareService$Stub")) == null || (g11 = g(f10, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return e(g11, null, e10);
    }

    public static Method d() {
        Object obj = f30039b;
        if (obj == null) {
            return null;
        }
        return g(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    public static Object e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            Log.w(f30038a, "Unexpected error while invoking " + method, e10);
            return null;
        } catch (RuntimeException e11) {
            Log.w(f30038a, "Unexpected error while invoking " + method, e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.w(f30038a, "Unexpected error while invoking " + method, e12.getCause());
            return null;
        }
    }

    public static Class<?> f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e10) {
            Log.w(f30038a, "Unexpected error while finding class " + str, e10);
            return null;
        }
    }

    public static Method g(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e10) {
            Log.w(f30038a, "Unexpected error while finding method " + str, e10);
            return null;
        }
    }

    public static void h() {
        Object obj = f30039b;
        if (obj != null) {
            e(f30040c, obj, Boolean.FALSE);
        }
    }
}
