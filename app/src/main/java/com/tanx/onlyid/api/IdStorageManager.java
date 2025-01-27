package com.tanx.onlyid.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import ug.h;

/* loaded from: classes4.dex */
public class IdStorageManager {

    /* renamed from: b */
    public static final String f21976b = "IdStorageManager";

    /* renamed from: c */
    public static IdStorageManager f21977c = null;

    /* renamed from: d */
    public static final String f21978d = "KEY_OAID";

    /* renamed from: e */
    public static final String f21979e = "KEY_IMEI";

    /* renamed from: f */
    public static final String f21980f = "KEY_CLIENT_ID";

    /* renamed from: g */
    public static final String f21981g = "KEY_ANDROID_ID";

    /* renamed from: h */
    public static final String f21982h = "KEY_WIDEVINE_ID";

    /* renamed from: i */
    public static final String f21983i = "KEY_PSEUDO_ID";

    /* renamed from: a */
    public SharedPreferences f21984a;

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ String f21985b;

        /* renamed from: c */
        public final /* synthetic */ String f21986c;

        public a(String str, String str2) {
            this.f21985b = str;
            this.f21986c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences.Editor edit = IdStorageManager.this.f21984a.edit();
                edit.putString(this.f21985b, this.f21986c);
                edit.apply();
            } catch (Exception unused) {
                Log.e(IdStorageManager.f21976b, "putString异常 key" + this.f21985b + " value:" + this.f21986c);
            }
        }
    }

    public IdStorageManager(Context context) {
        this.f21984a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static IdStorageManager c(Context context) {
        if (f21977c == null) {
            synchronized (IdStorageManager.class) {
                try {
                    if (f21977c == null) {
                        f21977c = new IdStorageManager(context);
                    }
                } finally {
                }
            }
        }
        return f21977c;
    }

    public String d(String str) {
        try {
            return this.f21984a.getString(str, "");
        } catch (Exception unused) {
            Log.e(f21976b, "getString异常 key:" + str);
            return "";
        }
    }

    public void e(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            f(str, str2);
            return;
        }
        Log.e("putId", "key:" + str + " v" + str2 + " 过程有key或value为空，终止");
    }

    public void f(String str, String str2) {
        h.b(new a(str, str2));
    }
}
