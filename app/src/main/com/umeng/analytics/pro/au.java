package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public class au {

    /* renamed from: a */
    public static final String f23460a = "cl_count";

    /* renamed from: b */
    public static final String f23461b = "interval_";

    /* renamed from: c */
    public static final String f23462c = "config_ts";

    /* renamed from: d */
    public static final String f23463d = "iucc_s1";

    /* renamed from: e */
    public static final String f23464e = "iucc_s2";

    /* renamed from: f */
    public static final String f23465f = "sdk_type_ver";

    /* renamed from: g */
    public static final String f23466g = "should_fetch";

    /* renamed from: h */
    public static final String f23467h = "last_type_index";

    /* renamed from: i */
    private static final String f23468i = "ccg_sp_config_file";

    private au() {
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f23468i, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
