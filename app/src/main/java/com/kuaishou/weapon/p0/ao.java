package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class ao {
    private boolean a(String str) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(str).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
            }
        }
        return true;
    }

    public boolean a() {
        try {
            Field declaredField = ClassLoader.getSystemClassLoader().loadClass(an.f9076b).getDeclaredField("disableHooks");
            declaredField.setAccessible(true);
            declaredField.set(null, Boolean.TRUE);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean b() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(an.f9076b)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean c() {
        return a(an.f9077c);
    }

    public boolean d() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.f9075a).newInstance();
            } catch (ClassNotFoundException unused) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused2) {
                return true;
            }
        }
        if (systemClassLoader != null) {
            try {
                systemClassLoader.loadClass(an.f9076b).newInstance();
            } catch (ClassNotFoundException unused3) {
                return false;
            } catch (IllegalAccessException | InstantiationException unused4) {
            }
        }
        return true;
    }

    public String e() {
        try {
            return System.getProperty("vxp");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean f() {
        try {
            String str = System.getenv("CLASSPATH");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("XposedBridge");
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean g() {
        try {
            return Modifier.isNative(Throwable.class.getDeclaredMethod("getStackTrace", new Class[0]).getModifiers());
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }
}
