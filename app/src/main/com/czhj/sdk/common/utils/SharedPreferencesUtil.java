package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.czhj.sdk.common.utils.Preconditions;

/* loaded from: classes2.dex */
public final class SharedPreferencesUtil {

    /* renamed from: a */
    public static String f8691a = "com.sigmob.Settings";

    public SharedPreferencesUtil(String str) {
        f8691a = str;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        Preconditions.NoThrow.checkNotNull(context);
        return context.getSharedPreferences(f8691a, 4);
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(str);
        return context.getSharedPreferences(str, 4);
    }
}
