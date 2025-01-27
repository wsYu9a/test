package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class TTAppContextHolder {

    /* renamed from: j */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context f6365j;

    private static class j {

        /* renamed from: j */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f6366j;

        static {
            try {
                Object zx = zx();
                f6366j = (Application) zx.getClass().getMethod("getApplication", new Class[0]).invoke(zx, new Object[0]);
                com.bytedance.sdk.openadsdk.api.j.g("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.j.zx("MyApplication", "application get failed", th);
            }
        }

        public static Application j() {
            return f6366j;
        }

        private static Object zx() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.j.zx("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (f6365j == null) {
            setContext(null);
        }
        return f6365j;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (f6365j == null) {
                if (context != null) {
                    f6365j = context.getApplicationContext();
                } else if (j.j() != null) {
                    try {
                        f6365j = j.j();
                        if (f6365j != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
