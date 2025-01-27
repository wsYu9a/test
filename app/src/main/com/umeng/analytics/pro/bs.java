package com.umeng.analytics.pro;

import android.util.Log;

/* loaded from: classes4.dex */
public class bs {

    /* renamed from: a */
    private static final String f23581a = "OpenId";

    /* renamed from: b */
    private static boolean f23582b = false;

    public static void a(boolean z10) {
        Log.d("OpenId", "setDebug:" + z10);
        f23582b = z10;
    }

    public static void b(String str, Object... objArr) {
        if (f23582b) {
            Log.i("OpenId", e(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f23582b) {
            Log.w("OpenId", e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (f23582b) {
            Log.e("OpenId", e(str, objArr));
        }
    }

    private static String e(String str, Object... objArr) {
        int i10 = 0;
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "-";
        }
        sb2.append(String.format("[%s] ", str));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb2.append(a(objArr[i10], objArr[i11]));
                if (i11 < length - 1) {
                    sb2.append(",");
                }
                i10 += 2;
            }
            if (i10 == objArr.length - 1) {
                sb2.append(objArr[i10]);
            }
        }
        return sb2.toString();
    }

    public static void a(String str, Object... objArr) {
        if (f23582b) {
            Log.d("OpenId", e(str, objArr));
        }
    }

    private static String a(Object obj, Object obj2) {
        if (obj == null) {
            obj = "";
        }
        if (obj2 == null) {
            obj2 = "";
        }
        return String.format("%s:%s", obj, obj2);
    }
}
