package com.kwad.sdk.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class s {
    private static final Map<Class<?>, Class<?>> azL;

    public static class a<T> {
        public final Class<? extends T> azM;
        public final T obj;
    }

    static {
        HashMap hashMap = new HashMap();
        azL = hashMap;
        Class cls = Boolean.TYPE;
        hashMap.put(Boolean.class, cls);
        hashMap.put(Byte.class, Byte.TYPE);
        hashMap.put(Character.class, Character.TYPE);
        hashMap.put(Short.class, Short.TYPE);
        Class cls2 = Integer.TYPE;
        hashMap.put(Integer.class, cls2);
        Class cls3 = Float.TYPE;
        hashMap.put(Float.class, cls3);
        Class cls4 = Long.TYPE;
        hashMap.put(Long.class, cls4);
        hashMap.put(Double.class, Double.TYPE);
        hashMap.put(cls, cls);
        Class cls5 = Byte.TYPE;
        hashMap.put(cls5, cls5);
        Class cls6 = Character.TYPE;
        hashMap.put(cls6, cls6);
        Class cls7 = Short.TYPE;
        hashMap.put(cls7, cls7);
        hashMap.put(cls2, cls2);
        hashMap.put(cls3, cls3);
        hashMap.put(cls4, cls4);
        Class cls8 = Double.TYPE;
        hashMap.put(cls8, cls8);
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, Object... objArr) {
        try {
            return (T) b(cls, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static <T> T a(Object obj, String str, Object... objArr) {
        try {
            return (T) c(obj, str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        try {
            return (T) c(Class.forName(str), str2, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static Object a(Field field, Object obj) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static Method a(Method[] methodArr, String str, Class<?>[] clsArr) {
        ao.eK(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && a(method.getParameterTypes(), clsArr, false)) {
                return method;
            }
        }
        return null;
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            b(cls, str, obj);
        } catch (Throwable th) {
            l(th);
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        try {
            b(obj, str, obj2);
        } catch (Throwable th) {
            l(th);
        }
    }

    public static void a(Field field, Object obj, Object obj2) {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if ((!z || (clsArr[i2] != null && clsArr2[i2] != null)) && !clsArr[i2].isAssignableFrom(clsArr2[i2])) {
                Map<Class<?>, Class<?>> map = azL;
                if (!map.containsKey(clsArr[i2]) || !map.get(clsArr[i2]).equals(map.get(clsArr2[i2]))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <T> T aa(String str, String str2) {
        try {
            return (T) ab(str, str2);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T ab(String str, String str2) {
        return (T) d(Class.forName(str), str2);
    }

    public static <T> T b(Class<?> cls, String str, Object... objArr) {
        try {
            return (T) c(cls, str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T b(Class<?> cls, Object... objArr) {
        return (T) cls.getConstructor(c(objArr)).newInstance(d(objArr));
    }

    public static <T> T b(Object obj, String str, Object... objArr) {
        try {
            return (T) d(obj, str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static Method b(Method[] methodArr, String str, Class<?>[] clsArr) {
        ao.eK(str);
        for (Method method : methodArr) {
            if (method.getName().equals(str) && b(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private static void b(Class<?> cls, String str, Object obj) {
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
        field.set(null, obj);
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

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        return a(clsArr, clsArr2, true);
    }

    public static <T> T c(Class<?> cls, String str) {
        try {
            return (T) d(cls, str);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static <T> T c(Class<?> cls, String str, Object... objArr) {
        return (T) c(cls, str, c(objArr)).invoke(null, d(objArr));
    }

    public static <T> T c(Object obj, String str, Object... objArr) {
        return (T) c(obj.getClass(), str, c(objArr)).invoke(obj, d(objArr));
    }

    public static <T> T c(String str, Object... objArr) {
        try {
            return (T) f(str, objArr);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method a2 = a(cls.getDeclaredMethods(), str, clsArr);
            if (a2 != null) {
                a2.setAccessible(true);
                return a2;
            }
            if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            }
            cls = cls.getSuperclass();
        }
    }

    private static Class<?>[] c(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            clsArr[i2] = (obj == null || !(obj instanceof a)) ? obj == null ? null : obj.getClass() : ((a) obj).azM;
        }
        return clsArr;
    }

    private static <T> T d(Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return (T) declaredField.get(null);
    }

    public static <T> T d(Object obj, String str) {
        try {
            return (T) e(obj, str);
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    private static <T> T d(Object obj, String str, Object... objArr) {
        return (T) e(obj.getClass(), str, c(objArr)).invoke(obj, d(objArr));
    }

    private static Object[] d(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof a)) {
                objArr2[i2] = obj;
            } else {
                objArr2[i2] = ((a) obj).obj;
            }
        }
        return objArr2;
    }

    public static <T> T e(Object obj, String str) {
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

    private static Method e(Class<?> cls, String str, Class<?>... clsArr) {
        while (true) {
            Method b2 = b(cls.getDeclaredMethods(), str, clsArr);
            if (b2 != null) {
                b2.setAccessible(true);
                return b2;
            }
            if (cls.getSuperclass() == null) {
                throw new NoSuchMethodException();
            }
            cls = cls.getSuperclass();
        }
    }

    public static <T> T eA(String str) {
        try {
            return (T) j(Class.forName(str));
        } catch (Throwable th) {
            l(th);
            return null;
        }
    }

    public static boolean ez(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    private static <T> T f(String str, Object... objArr) {
        return (T) b(Class.forName(str), d(objArr));
    }

    public static <T> T i(Class<?> cls) {
        try {
            return (T) j(cls);
        } catch (Throwable th) {
            l(th);
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
            return (T) constructor.newInstance(new Object[0]);
        }
        Object[] objArr = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            objArr[i2] = k(parameterTypes[i2]);
        }
        return (T) constructor.newInstance(objArr);
    }

    private static Object k(Class<?> cls) {
        if (Integer.TYPE.equals(cls) || Integer.class.equals(cls) || Byte.TYPE.equals(cls) || Byte.class.equals(cls) || Short.TYPE.equals(cls) || Short.class.equals(cls) || Long.TYPE.equals(cls) || Long.class.equals(cls) || Double.TYPE.equals(cls) || Double.class.equals(cls) || Float.TYPE.equals(cls) || Float.class.equals(cls)) {
            return 0;
        }
        return (Boolean.TYPE.equals(cls) || Boolean.class.equals(cls)) ? Boolean.FALSE : (Character.TYPE.equals(cls) || Character.class.equals(cls)) ? (char) 0 : null;
    }

    private static void l(Throwable th) {
        if (!com.kwad.a.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        } else {
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
            throw ((RuntimeException) th);
        }
    }
}
