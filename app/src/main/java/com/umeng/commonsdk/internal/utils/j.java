package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private static final String f26236a = "um_pri";

    /* renamed from: b */
    private static final String f26237b = "um_common_strength";

    /* renamed from: c */
    private static final String f26238c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26236a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f26238c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26236a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f26238c, str).commit();
    }
}
