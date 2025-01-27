package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private static final String f24546a = bd.b().b(bd.f23538r);

    /* renamed from: b */
    private static final String f24547b = "um_common_strength";

    /* renamed from: c */
    private static final String f24548c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f24546a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f24548c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f24546a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f24548c, str).commit();
    }
}
