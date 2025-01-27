package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    public static final String f9326a = "re_po_rt";

    /* renamed from: e */
    private static h f9327e;

    /* renamed from: b */
    private SharedPreferences f9328b;

    /* renamed from: c */
    private SharedPreferences.Editor f9329c;

    /* renamed from: d */
    private Context f9330d;

    public h(Context context) {
        try {
            this.f9330d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f9328b = sharedPreferences;
            this.f9329c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public h(Context context, String str) {
        try {
            this.f9330d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f9328b = sharedPreferences;
            this.f9329c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static h a() {
        return f9327e;
    }

    public static synchronized h a(Context context, String str) {
        h hVar;
        synchronized (h.class) {
            if (f9327e == null) {
                synchronized (h.class) {
                    if (f9327e == null) {
                        f9327e = new h(context, str);
                    }
                }
            }
            hVar = f9327e;
        }
        return hVar;
    }

    public long a(String str, long j2) {
        return this.f9328b.getLong(str, j2);
    }

    public String a(String str) {
        return this.f9328b.getString(str, "");
    }

    public void a(Context context) {
        this.f9330d = context;
    }

    public void a(String str, int i2) {
        try {
            this.f9329c.putInt(str, i2);
            this.f9329c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, int i2, boolean z) {
        try {
            this.f9329c.putInt(str, i2);
            if (z) {
                this.f9329c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Boolean bool) {
        this.f9329c.putBoolean(str, bool.booleanValue());
        this.f9329c.apply();
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f9329c.putString(str, str2);
            this.f9329c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f9329c.putString(str, str2);
            if (z) {
                this.f9329c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public int b(String str) {
        try {
            return this.f9328b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int b(String str, int i2) {
        try {
            return this.f9328b.getInt(str, i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public Context b() {
        return this.f9330d;
    }

    public String b(String str, String str2) {
        return this.f9328b.getString(str, str2);
    }

    public String b(String str, String str2, boolean z) {
        String b2 = b(str, "");
        return !TextUtils.isEmpty(b2) ? z ? c.b(b2, 2) : b2 : str2;
    }

    public void b(String str, long j2) {
        this.f9329c.putLong(str, j2);
        this.f9329c.apply();
    }

    public int c(String str) {
        try {
            return this.f9328b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int c(String str, int i2) {
        try {
            return this.f9328b.getInt(str, i2);
        } catch (Exception unused) {
            return i2;
        }
    }

    public void c() {
        try {
            this.f9329c.apply();
        } catch (Throwable unused) {
        }
    }

    public void c(String str, String str2) {
        try {
            this.f9329c.putString(str, str2);
            this.f9329c.apply();
        } catch (Exception unused) {
        }
    }

    public void c(String str, String str2, boolean z) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z) {
                str2 = c.b(str2.getBytes(), 2);
            }
            this.f9329c.putString(str, str2);
            this.f9329c.apply();
        } catch (Throwable unused) {
        }
    }

    public long d(String str) {
        return this.f9328b.getLong(str, 0L);
    }

    public void d(String str, int i2) {
        this.f9329c.putInt(str, i2);
        this.f9329c.apply();
    }

    public boolean e(String str) {
        return this.f9328b.getBoolean(str, false);
    }
}
