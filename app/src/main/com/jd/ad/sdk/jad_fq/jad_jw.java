package com.jd.ad.sdk.jad_fq;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class jad_jw {
    public static Method jad_an;
    public static Method jad_bo;
    public static Method jad_cp;

    static {
        try {
            jad_an = Class.class.getDeclaredMethod("forName", String.class);
            jad_bo = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            jad_cp = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Nullable
    public static Method jad_an(@NonNull String str, @NonNull String str2, Class[] clsArr) {
        Throwable th2;
        Method method = jad_an;
        Method method2 = null;
        if (method == null || jad_bo == null || jad_cp == null) {
            return null;
        }
        try {
            try {
                Method method3 = (Method) jad_bo.invoke((Class) method.invoke(null, str), str2, clsArr);
                try {
                    method3.setAccessible(true);
                    return method3;
                } catch (Throwable th3) {
                    th2 = th3;
                    method2 = method3;
                    th2.printStackTrace();
                    return method2;
                }
            } catch (Throwable th4) {
                th2 = th4;
            }
        } catch (Throwable th5) {
            th2 = th5;
        }
    }
}
