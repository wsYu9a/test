package com.bytedance.pangle.b.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a */
    private static Map<String, Field> f7473a = new HashMap();

    /* renamed from: b */
    private static Map<String, Method> f7474b = new HashMap();

    /* renamed from: c */
    private static Map<String, Constructor> f7475c = new HashMap();

    /* renamed from: d */
    private static Map<String, Class> f7476d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e10) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e10);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String b10 = b(cls, str, clsArr);
        synchronized (f7474b) {
            method = f7474b.get(b10);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method a10 = b.a(cls, str, clsArr);
            if (a10 != null) {
                synchronized (f7474b) {
                    f7474b.put(b10, a10);
                }
            }
            return a10;
        } catch (Throwable th2) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th2);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cls.getName());
        sb2.append("#");
        sb2.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb2.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb2.append(cls2.getName());
                sb2.append("#");
            }
        }
        return sb2.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String b10 = b(cls, "clinit", clsArr);
        synchronized (f7475c) {
            constructor = f7475c.get(b10);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor a10 = b.a(cls, clsArr);
            if (a10 != null) {
                synchronized (f7475c) {
                    f7475c.put(b10, a10);
                }
            }
            return a10;
        } catch (Throwable th2) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th2);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (f7473a) {
            field = f7473a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field a10 = b.a(cls, str);
            if (a10 != null) {
                synchronized (f7473a) {
                    f7473a.put(str2, a10);
                }
            }
            return a10;
        } catch (Throwable th2) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th2);
            return null;
        }
    }
}
