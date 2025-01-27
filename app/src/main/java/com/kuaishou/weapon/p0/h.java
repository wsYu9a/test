package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a */
    public static final String f11111a = "re_po_rt";

    /* renamed from: e */
    private static h f11112e;

    /* renamed from: b */
    private SharedPreferences f11113b;

    /* renamed from: c */
    private SharedPreferences.Editor f11114c;

    /* renamed from: d */
    private Context f11115d;

    public h(Context context, String str) {
        try {
            this.f11115d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 4);
            this.f11113b = sharedPreferences;
            this.f11114c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public static synchronized h a(Context context, String str) {
        h hVar;
        synchronized (h.class) {
            try {
                if (f11112e == null) {
                    synchronized (h.class) {
                        try {
                            if (f11112e == null) {
                                f11112e = new h(context, str);
                            }
                        } finally {
                        }
                    }
                }
                hVar = f11112e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hVar;
    }

    public Context b() {
        return this.f11115d;
    }

    public void c(String str, String str2) {
        try {
            this.f11114c.putString(str, str2);
            this.f11114c.apply();
        } catch (Exception unused) {
        }
    }

    public void d(String str, int i10) {
        this.f11114c.putInt(str, i10);
        this.f11114c.apply();
    }

    public boolean e(String str) {
        return this.f11113b.getBoolean(str, false);
    }

    public int b(String str) {
        try {
            return this.f11113b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public int b(String str, int i10) {
        try {
            return this.f11113b.getInt(str, i10);
        } catch (Exception unused) {
            return i10;
        }
    }

    public void c(String str, String str2, boolean z10) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (z10) {
                str2 = c.b(str2.getBytes(), 2);
            }
            this.f11114c.putString(str, str2);
            this.f11114c.apply();
        } catch (Throwable unused) {
        }
    }

    public long d(String str) {
        return this.f11113b.getLong(str, 0L);
    }

    public String b(String str, String str2) {
        return this.f11113b.getString(str, str2);
    }

    public h(Context context) {
        try {
            this.f11115d = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("re_po_rt", 4);
            this.f11113b = sharedPreferences;
            this.f11114c = sharedPreferences.edit();
        } catch (Throwable unused) {
        }
    }

    public String b(String str, String str2, boolean z10) {
        String b10 = b(str, "");
        return !TextUtils.isEmpty(b10) ? z10 ? c.b(b10, 2) : b10 : str2;
    }

    public static h a() {
        return f11112e;
    }

    public int c(String str, int i10) {
        try {
            return this.f11113b.getInt(str, i10);
        } catch (Exception unused) {
            return i10;
        }
    }

    public void a(Context context) {
        this.f11115d = context;
    }

    public void b(String str, long j10) {
        this.f11114c.putLong(str, j10);
        this.f11114c.apply();
    }

    public int c(String str) {
        try {
            return this.f11113b.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f11114c.putString(str, str2);
            this.f11114c.apply();
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            this.f11114c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2, boolean z10) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f11114c.putString(str, str2);
            if (z10) {
                this.f11114c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        return this.f11113b.getString(str, "");
    }

    public void a(String str, int i10) {
        try {
            this.f11114c.putInt(str, i10);
            this.f11114c.apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, int i10, boolean z10) {
        try {
            this.f11114c.putInt(str, i10);
            if (z10) {
                this.f11114c.apply();
            }
        } catch (Throwable unused) {
        }
    }

    public long a(String str, long j10) {
        return this.f11113b.getLong(str, j10);
    }

    public void a(String str, Boolean bool) {
        this.f11114c.putBoolean(str, bool.booleanValue());
        this.f11114c.apply();
    }
}
