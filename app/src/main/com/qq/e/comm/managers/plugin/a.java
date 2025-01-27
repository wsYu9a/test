package com.qq.e.comm.managers.plugin;

import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a */
    private static Method f16591a = null;

    /* renamed from: b */
    private static boolean f16592b = false;

    public static void a(Throwable th2, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th2);
            if (f16592b) {
                return;
            }
            if (f16591a == null) {
                Method declaredMethod = CrashReport.class.getDeclaredMethod("postCatchedException", Throwable.class);
                f16591a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f16591a.invoke(null, exc);
        } catch (Throwable unused) {
            f16592b = true;
        }
    }
}
