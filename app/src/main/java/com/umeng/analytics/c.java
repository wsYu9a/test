package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static String[] f25602a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f25602a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f25602a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static String[] a(Context context) {
        String[] a2;
        if (!TextUtils.isEmpty(f25602a[0]) && !TextUtils.isEmpty(f25602a[1])) {
            return f25602a;
        }
        if (context == null || (a2 = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f25602a;
        strArr[0] = a2[0];
        strArr[1] = a2[1];
        return strArr;
    }
}
