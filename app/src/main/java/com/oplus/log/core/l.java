package com.oplus.log.core;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a */
    private static SimpleDateFormat f16170a = new SimpleDateFormat("yyyy-MM-dd");

    public static long a() {
        try {
            return f16170a.parse(f16170a.format(new Date(System.currentTimeMillis()))).getTime();
        } catch (Exception e2) {
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
            return 0L;
        }
    }

    public static boolean b(String str, Class cls) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            Class<?> cls2 = Runtime.getRuntime().getClass();
            Class<?>[] clsArr = new Class[2];
            if (Build.VERSION.SDK_INT > 24) {
                clsArr[0] = ClassLoader.class;
                clsArr[1] = String.class;
                Method declaredMethod = cls2.getDeclaredMethod("loadLibrary0", clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(Runtime.getRuntime(), classLoader, str);
            } else {
                clsArr[0] = String.class;
                clsArr[1] = ClassLoader.class;
                Method declaredMethod2 = cls2.getDeclaredMethod("loadLibrary", clsArr);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(Runtime.getRuntime(), str, classLoader);
            }
            return true;
        } catch (IllegalAccessException e2) {
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
            return false;
        } catch (NoSuchMethodException e3) {
            if (b.h.a.c.j()) {
                e3.printStackTrace();
            }
            return false;
        } catch (InvocationTargetException e4) {
            if (b.h.a.c.j()) {
                e4.printStackTrace();
            }
            return false;
        } catch (Throwable th) {
            if (b.h.a.c.j()) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
