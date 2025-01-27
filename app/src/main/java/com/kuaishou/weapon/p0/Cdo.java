package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.kuaishou.weapon.p0.do, reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9297a = "plc001_t_re";

    /* renamed from: b, reason: collision with root package name */
    public static final String f9298b = "wlpauct2";

    /* renamed from: c, reason: collision with root package name */
    public static final String f9299c = "plc001_pd_ptip_pi";

    /* renamed from: d, reason: collision with root package name */
    public static final String f9300d = "wiipaot";

    /* renamed from: e, reason: collision with root package name */
    public static final int f9301e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final String f9302f = "a1_p_s_p_s";

    /* renamed from: g, reason: collision with root package name */
    public static final String f9303g = "a1_p_s_p_s_c_b";

    /* renamed from: j, reason: collision with root package name */
    private static Cdo f9304j;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f9305h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f9306i;

    private Cdo(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bh.r, 4);
            this.f9305h = sharedPreferences;
            this.f9306i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static Cdo a() {
        return f9304j;
    }

    public static synchronized Cdo a(Context context) {
        Cdo cdo;
        synchronized (Cdo.class) {
            try {
                if (f9304j == null) {
                    f9304j = new Cdo(context);
                }
                cdo = f9304j;
            } catch (Exception unused) {
                return null;
            }
        }
        return cdo;
    }

    public int a(String str, int i2) {
        try {
            return this.f9305h.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long a(String str) {
        return this.f9305h.getLong(str, 0L);
    }

    public String a(String str, String str2) {
        return this.f9305h.getString(str, str2);
    }

    public void a(String str, int i2, boolean z) {
        try {
            this.f9306i.putInt(str, i2);
            if (z) {
                this.f9306i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, long j2, boolean z) {
        try {
            this.f9306i.putLong(str, j2);
            if (z) {
                this.f9306i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z) {
        try {
            SharedPreferences.Editor editor = this.f9306i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z) {
                    this.f9306i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str, String str2) {
        try {
            this.f9306i.putString(str, str2);
            this.f9306i.apply();
        } catch (Exception unused) {
        }
    }

    public boolean b(String str) {
        return this.f9305h.getBoolean(str, false);
    }
}
