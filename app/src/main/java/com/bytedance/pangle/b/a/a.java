package com.bytedance.pangle.b.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static Map<String, Field> f5996a = new HashMap();

    /* renamed from: b */
    private static Map<String, Method> f5997b = new HashMap();

    /* renamed from: c */
    private static Map<String, Constructor> f5998c = new HashMap();

    /* renamed from: d */
    private static Map<String, Class> f5999d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e2);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String b2 = b(cls, str, clsArr);
        synchronized (f5997b) {
            method = f5997b.get(b2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method a2 = b.a(cls, str, clsArr);
            if (a2 != null) {
                synchronized (f5997b) {
                    f5997b.put(b2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String b2 = b(cls, "clinit", clsArr);
        synchronized (f5998c) {
            constructor = f5998c.get(b2);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor a2 = b.a(cls, clsArr);
            if (a2 != null) {
                synchronized (f5998c) {
                    f5998c.put(b2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (f5996a) {
            field = f5996a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field a2 = b.a(cls, str);
            if (a2 != null) {
                synchronized (f5996a) {
                    f5996a.put(str2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
