package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.c;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class TTAppContextHolder {

    /* renamed from: a */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context f7959a;

    public static class a {

        /* renamed from: a */
        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application f7960a;

        static {
            try {
                Object b10 = b();
                f7960a = (Application) b10.getClass().getMethod("getApplication", null).invoke(b10, null);
                c.d("MyApplication", "application get success");
            } catch (Throwable th2) {
                c.c("MyApplication", "application get failed", th2);
            }
        }

        public static Application a() {
            return f7960a;
        }

        private static Object b() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", null);
                method.setAccessible(true);
                return method.invoke(null, null);
            } catch (Throwable th2) {
                c.c("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th2);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (f7959a == null) {
            setContext(null);
        }
        return f7959a;
    }

    public static synchronized void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            if (f7959a == null) {
                if (context != null) {
                    f7959a = context.getApplicationContext();
                } else if (a.a() != null) {
                    try {
                        f7959a = a.a();
                        if (f7959a != null) {
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
