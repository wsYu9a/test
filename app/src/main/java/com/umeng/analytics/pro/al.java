package com.umeng.analytics.pro;

import android.util.Log;

/* loaded from: classes4.dex */
public class al {

    /* renamed from: a */
    private static final String f25648a = "OpenId";

    /* renamed from: b */
    private static boolean f25649b = false;

    public static void a(boolean z) {
        Log.d(f25648a, "setDebug:" + z);
        f25649b = z;
    }

    public static void b(String str, Object... objArr) {
        if (f25649b) {
            Log.i(f25648a, e(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f25649b) {
            Log.w(f25648a, e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (f25649b) {
            Log.e(f25648a, e(str, objArr));
        }
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i2 = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i2], objArr[i3]));
                if (i3 < length - 1) {
                    sb.append(",");
                }
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    public static void a(String str, Object... objArr) {
        if (f25649b) {
            Log.d(f25648a, e(str, objArr));
        }
    }

    private static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }
}
