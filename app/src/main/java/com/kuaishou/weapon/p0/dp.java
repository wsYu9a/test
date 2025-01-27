package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class dp {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11081a = "plc001_t_re";

    /* renamed from: b, reason: collision with root package name */
    public static final String f11082b = "wlpauct2";

    /* renamed from: c, reason: collision with root package name */
    public static final String f11083c = "plc001_pd_ptip_pi";

    /* renamed from: d, reason: collision with root package name */
    public static final String f11084d = "wiipaot";

    /* renamed from: e, reason: collision with root package name */
    public static final int f11085e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final String f11086f = "a1_p_s_p_s";

    /* renamed from: g, reason: collision with root package name */
    public static final String f11087g = "a1_p_s_p_s_c_b";

    /* renamed from: j, reason: collision with root package name */
    private static dp f11088j;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f11089h;

    /* renamed from: i, reason: collision with root package name */
    private SharedPreferences.Editor f11090i;

    private dp(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(bi.f10822r, 4);
            this.f11089h = sharedPreferences;
            this.f11090i = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized dp a(Context context) {
        dp dpVar;
        synchronized (dp.class) {
            try {
                if (f11088j == null) {
                    f11088j = new dp(context);
                }
                dpVar = f11088j;
            } catch (Exception unused) {
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dpVar;
    }

    public boolean b(String str) {
        return this.f11089h.getBoolean(str, false);
    }

    public void b(String str, String str2) {
        try {
            this.f11090i.putString(str, str2);
            this.f11090i.apply();
        } catch (Exception unused) {
        }
    }

    public static dp a() {
        return f11088j;
    }

    public long a(String str) {
        return this.f11089h.getLong(str, 0L);
    }

    public void a(String str, long j10, boolean z10) {
        try {
            this.f11090i.putLong(str, j10);
            if (z10) {
                this.f11090i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int a(String str, int i10) {
        try {
            return this.f11089h.getInt(str, i10);
        } catch (Throwable unused) {
            return i10;
        }
    }

    public void a(String str, int i10, boolean z10) {
        try {
            this.f11090i.putInt(str, i10);
            if (z10) {
                this.f11090i.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool, boolean z10) {
        try {
            SharedPreferences.Editor editor = this.f11090i;
            if (editor != null) {
                editor.putBoolean(str, bool.booleanValue());
                if (z10) {
                    this.f11090i.apply();
                }
            }
        } catch (Exception unused) {
        }
    }

    public String a(String str, String str2) {
        return this.f11089h.getString(str, str2);
    }
}
