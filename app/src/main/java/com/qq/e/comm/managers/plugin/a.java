package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static Method f24029a = null;

    /* renamed from: b */
    private static boolean f24030b = false;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (f24030b) {
                return;
            }
            if (f24029a == null) {
                Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                f24029a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f24029a.invoke(null, exc);
        } catch (Throwable unused) {
            f24030b = true;
        }
    }
}
