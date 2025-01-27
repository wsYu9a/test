package com.sigmob.sdk.base.utils;

import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    public static String f18416a = "com.wind.Settings";

    public static int a(String str, int i10) {
        return com.sigmob.sdk.a.d().getSharedPreferences(f18416a, 4).getInt(str, i10);
    }

    public static SharedPreferences a() {
        return com.sigmob.sdk.a.d().getSharedPreferences(f18416a, 4);
    }

    public static SharedPreferences a(String str) {
        return com.sigmob.sdk.a.d().getSharedPreferences(str, 4);
    }

    public static String a(String str, String str2) {
        return com.sigmob.sdk.a.d().getSharedPreferences(f18416a, 4).getString(str, str2);
    }
}
