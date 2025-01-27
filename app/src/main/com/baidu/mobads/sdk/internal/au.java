package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes2.dex */
public class au {

    /* renamed from: a */
    static bt f6790a = bt.a();

    /* renamed from: b */
    private static final String f6791b = "com.baidu.mobads.sdk.internal.au";

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e10) {
                f6790a.a(f6791b, Log.getStackTraceString(e10));
            }
        }
        return null;
    }

    public static Field b(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e10) {
                f6790a.b(f6791b, Log.getStackTraceString(e10));
            }
        }
        return null;
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Class<?> a10 = a(str, classLoader);
            if (a10 == null) {
                return null;
            }
            Method declaredMethod = a10.getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Field b(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e10) {
                f6790a.b(f6791b, Log.getStackTraceString(e10));
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (NoSuchMethodException unused) {
            return false;
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return false;
        }
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        Field b10 = b(obj, str);
        if (b10 == null) {
            return null;
        }
        b10.setAccessible(true);
        try {
            return b10.get(obj);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(Class cls, String str) {
        Field b10 = b((Class<?>) cls, str);
        if (b10 == null) {
            return null;
        }
        b10.setAccessible(true);
        try {
            return b10.get(cls);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(Object obj, String str, Object... objArr) {
        try {
            return a(obj.getClass(), obj, str, a(objArr), objArr);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Class<?>[] a(Object... objArr) {
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                clsArr[i10] = objArr[i10].getClass();
            }
            return clsArr;
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a10 = a(str, classLoader);
            if (a10 != null) {
                return a10.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a10 = a(str);
            if (a10 != null) {
                return a10.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, InvocationHandler invocationHandler) {
        Class<?> a10 = a(str, classLoader);
        if (a10 != null) {
            return Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, InvocationHandler invocationHandler) {
        Class<?> a10 = a(str);
        if (a10 != null) {
            return Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, invocationHandler);
        }
        return null;
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a10 = a(str, classLoader);
            if (a10 == null || (declaredMethod = a10.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a10 = a(str);
            if (a10 == null || (declaredMethod = a10.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static Object a(ClassLoader classLoader, String str, String str2) {
        try {
            return a((Class) Class.forName(str, true, classLoader), str2);
        } catch (Exception e10) {
            f6790a.b(f6791b, Log.getStackTraceString(e10));
            return null;
        }
    }

    public static ClassLoader a(Context context) {
        return an.a(bz.a(context), context.getFilesDir().getAbsolutePath(), (String) null, au.class.getClassLoader());
    }
}
