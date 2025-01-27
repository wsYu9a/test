package com.martian.libmars.utils.x0;

import android.os.Build;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    static boolean f10294a = false;

    public static void a() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
        } catch (NoSuchMethodException unused) {
            f10294a |= Build.BRAND.contains("Meizu");
        }
    }
}
