package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private static d f24628a;

    /* renamed from: b */
    private static Context f24629b;

    /* renamed from: c */
    private static String f24630c;

    /* renamed from: d */
    private static final String f24631d = bd.b().b(bd.f23533m);

    public d(Context context) {
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            try {
                f24629b = context.getApplicationContext();
                f24630c = context.getPackageName();
                if (f24628a == null) {
                    f24628a = new d(context);
                }
                dVar = f24628a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    private SharedPreferences f() {
        return f24629b.getSharedPreferences(f24631d + f24630c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24629b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f24629b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f10 = f();
            String string = f10.getString("au_p", null);
            String string2 = f10.getString("au_u", null);
            if (string == null || string2 == null) {
                return null;
            }
            return new String[]{string, string2};
        } catch (Exception unused) {
            return null;
        }
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24629b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i10).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24629b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24629b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
