package com.aggmoread.sdk.z.d.a.a.e.r;

import java.util.Arrays;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    static final String f6138a = "g";

    /* renamed from: b */
    static boolean f6139b = true;

    public static boolean a(String[] strArr) {
        if (f6139b || strArr == null) {
            return true;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(f6138a, "---- contains enter , classPrefix = " + Arrays.toString(strArr));
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length - 1;
        for (int i10 = 0; i10 < length; i10++) {
            String className = stackTrace[i10].getClassName();
            for (String str : strArr) {
                if (className.startsWith(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("className = ");
                    sb2.append(className);
                    sb2.append(" , count = ");
                    sb2.append(i10 - 3);
                    sb2.append(" , len = ");
                    sb2.append(length);
                    com.aggmoread.sdk.z.d.a.a.e.e.b("xxxx", sb2.toString());
                    return true;
                }
            }
        }
        return false;
    }
}
