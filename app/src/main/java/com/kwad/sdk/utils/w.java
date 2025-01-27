package com.kwad.sdk.utils;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class w {
    private static final Map<Class<?>, Class<?>> aTq;
    private static Map<String, Method> aTr;
    private static final HashMap<Class<?>, Class<?>> aTs;
    private static Method aTt;
    private static Method aTu;
    private static Method aTv;

    public static class a<T> {
        public final Class<? extends T> aTw;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        aTq = hashMap;
        aTr = new HashMap();
        HashMap<Class<?>, Class<?>> hashMap2 = new HashMap<>();
        aTs = hashMap2;
        Class<?> cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        Class<?> cls2 = Byte.TYPE;
        hashMap.put(Byte.class, cls2);
        Class<?> cls3 = Character.TYPE;
        hashMap.put(Character.class, cls3);
        Class<?> cls4 = Short.TYPE;
        hashMap.put(Short.class, cls4);
        Class<?> cls5 = Integer.TYPE;
        hashMap.put(Integer.class, cls5);
        Class<?> cls6 = Float.TYPE;
        hashMap.put(Float.class, cls6);
        Class<?> cls7 = Long.TYPE;
        hashMap.put(Long.class, cls7);
        Class<?> cls8 = Double.TYPE;
        hashMap.put(Double.class, cls8);
        hashMap.put(cls, cls);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        hashMap.put(cls5, cls5);
        hashMap.put(cls6, cls6);
        hashMap.put(cls7, cls7);
        hashMap.put(cls8, cls8);
        hashMap2.put(cls, Boolean.class);
        hashMap2.put(cls2, Byte.class);
        hashMap2.put(cls3, Character.class);
        hashMap2.put(cls4, Short.class);
        hashMap2.put(cls5, Integer.class);
        hashMap2.put(cls7, Long.class);
        hashMap2.put(cls8, Double.class);
        hashMap2.put(cls6, Float.class);
        hashMap2.put(Void.TYPE, Void.class);
        try {
            aTt = Class.class.getDeclaredMethod("forName", String.class);
            aTu = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            aTv = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static Application By() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private static boolean Nf() {
        return (aTt == null || aTu == null || aTv == null) ? false : true;
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th2) {
            s(th2);
        }
    }

    public static <T> T ap(String str, String str2) {
        try {
            return (T) aq(str, str2);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    private static <T> T aq(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static void b(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    @Deprecated
    public static <T> T callMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) f(obj, str, objArr);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    @Deprecated
    public static <T> T callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) b(cls, str, objArr);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    public static boolean classExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return false;
        }
    }

    private static <T> T d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    private static Object[] e(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i10] = obj;
            } else {
                objArr2[i10] = ((a) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T f(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    public static <T> T gJ(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    public static <T> T getField(Object obj, String str) {
        try {
            return (T) f(obj, str);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    public static <T> T h(String str, Object... objArr) {
        try {
            return (T) j(str, objArr);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    private static <T> T j(Class<?> cls) {
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors == null || declaredConstructors.length == 0) {
            throw new IllegalArgumentException("Can't get even one available constructor for " + cls);
        }
        Constructor<?> constructor = declaredConstructors[0];
        constructor.setAccessible(true);
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length == 0) {
            return (T) constructor.newInstance(null);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            objArr[i10] = k(parameterTypes[i10]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object k(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    private static void s(Throwable th2) {
        if (!com.kwad.library.a.a.ns.booleanValue()) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        } else {
            if (!(th2 instanceof RuntimeException)) {
                throw new RuntimeException(th2);
            }
            throw ((RuntimeException) th2);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }

    private static boolean c(Class<?> cls, Class<?> cls2) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (cls.isPrimitive() && !cls2.isPrimitive()) {
            cls = aTs.get(cls);
        }
        if (cls2.isPrimitive() && !cls.isPrimitive()) {
            cls2 = aTs.get(cls2);
        }
        return cls2.isAssignableFrom(cls);
    }

    @Deprecated
    private static Class<?>[] d(Object... objArr) {
        Class<?> cls;
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj != null && (obj instanceof a)) {
                cls = ((a) obj).aTw;
            } else {
                cls = obj == null ? null : obj.getClass();
            }
            clsArr[i10] = cls;
        }
        return clsArr;
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    private static <T> T b(Class<?> cls, String str, Object... objArr) {
        return (T) f(cls, str, d(objArr)).invoke(null, e(objArr));
    }

    private static String e(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.toString());
        sb2.append("#");
        sb2.append(str);
        sb2.append("#");
        sb2.append(cls.getClassLoader() != null ? Integer.valueOf(cls.getClassLoader().hashCode()) : "");
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb2.append(cls2.toString());
                sb2.append("#");
            }
        } else {
            sb2.append(Void.class.toString());
        }
        return sb2.toString();
    }

    public static <T> T f(Object obj, String str, Object... objArr) {
        return (T) f(obj.getClass(), str, d(objArr)).invoke(obj, e(objArr));
    }

    private static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(d(objArr)).newInstance(e(objArr));
    }

    private static Method f(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String e10 = e(cls, str, clsArr);
        synchronized (aTr) {
            method = aTr.get(e10);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            com.kwad.sdk.core.d.c.d("JavaCalls_", "in new get method from cache: key：" + e10 + " method:" + method.getName());
            return method;
        }
        while (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method == null) {
                try {
                    for (Method method2 : cls.getDeclaredMethods()) {
                        if (method2 != null && TextUtils.equals(method2.getName(), str)) {
                            Class<?>[] parameterTypes = method2.getParameterTypes();
                            if (clsArr != null && parameterTypes != null && clsArr.length == parameterTypes.length) {
                                boolean z10 = true;
                                for (int i10 = 0; i10 < clsArr.length; i10++) {
                                    if (!c(clsArr[i10], parameterTypes[i10])) {
                                        z10 = false;
                                    }
                                }
                                if (z10) {
                                    method = method2;
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (method != null) {
                method.setAccessible(true);
                synchronized (aTr) {
                    aTr.put(e10, method);
                    com.kwad.sdk.core.d.c.d("JavaCalls_", "in new get method:" + method.getName());
                }
                return method;
            }
            cls = cls.getSuperclass();
        }
        throw new NoSuchMethodException();
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) b(Class.forName(str), str2, objArr);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    private static <T> T j(String str, Object... objArr) {
        return (T) b(Class.forName(str), e(objArr));
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th2) {
            s(th2);
            return null;
        }
    }

    @Nullable
    private static Method a(@NonNull String str, @NonNull String str2, Class[] clsArr) {
        Method method = null;
        if (!Nf()) {
            return null;
        }
        try {
            try {
                Method method2 = (Method) aTu.invoke((Class) aTt.invoke(null, str), str2, clsArr);
                try {
                    method2.setAccessible(true);
                    return method2;
                } catch (Throwable th2) {
                    th = th2;
                    method = method2;
                    s(th);
                    th.printStackTrace();
                    return method;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static Object a(@NonNull Object obj, @NonNull String str, @NonNull String str2) {
        try {
            Method a10 = a(str, str2, (Class[]) null);
            if (a10 != null) {
                return a10.invoke(obj, null);
            }
            return null;
        } catch (Throwable th2) {
            s(th2);
            th2.printStackTrace();
            return null;
        }
    }

    public static Object a(@NonNull String str, @NonNull String str2, Class[] clsArr, Object... objArr) {
        try {
            Method a10 = a(str, str2, clsArr);
            if (a10 != null) {
                return a10.invoke(null, objArr);
            }
            return null;
        } catch (Throwable th2) {
            s(th2);
            th2.printStackTrace();
            return null;
        }
    }
}
