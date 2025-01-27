package b.f.a.a.a;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4816a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static final Object f4817b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f4818c;

    static {
        String simpleName = d.class.getSimpleName();
        Object c2 = c();
        f4817b = c2;
        f4818c = d();
        if (c2 == null) {
            Log.v(simpleName, "This device does supports control of a flashlight");
        } else {
            Log.v(simpleName, "This device does not support control of a flashlight");
        }
    }

    private d() {
    }

    static void a() {
        h();
    }

    static void b() {
        h();
    }

    private static Object c() {
        Method g2;
        Object e2;
        Class<?> f2;
        Method g3;
        Class<?> f3 = f("android.os.ServiceManager");
        if (f3 == null || (g2 = g(f3, "getService", String.class)) == null || (e2 = e(g2, null, "hardware")) == null || (f2 = f("android.os.IHardwareService$Stub")) == null || (g3 = g(f2, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return e(g3, null, e2);
    }

    private static Method d() {
        Object obj = f4817b;
        if (obj == null) {
            return null;
        }
        return g(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    private static Object e(Method method, Object instance, Object... args) {
        try {
            return method.invoke(instance, args);
        } catch (IllegalAccessException e2) {
            Log.w(f4816a, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (RuntimeException e3) {
            Log.w(f4816a, "Unexpected error while invoking " + method, e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.w(f4816a, "Unexpected error while invoking " + method, e4.getCause());
            return null;
        }
    }

    private static Class<?> f(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e2) {
            Log.w(f4816a, "Unexpected error while finding class " + name, e2);
            return null;
        }
    }

    private static Method g(Class<?> clazz, String name, Class<?>... argClasses) {
        try {
            return clazz.getMethod(name, argClasses);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e2) {
            Log.w(f4816a, "Unexpected error while finding method " + name, e2);
            return null;
        }
    }

    private static void h() {
        Object obj = f4817b;
        if (obj != null) {
            e(f4818c, obj, Boolean.FALSE);
        }
    }
}
