package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class bm {

    /* renamed from: a */
    public static final String f6896a = "mobads_builds";

    /* renamed from: b */
    public static final String f6897b = "brand_period";

    /* renamed from: c */
    public static final String f6898c = "version_period";

    /* renamed from: d */
    public static final long f6899d = 604800000;

    /* renamed from: e */
    public static final long f6900e = 172800000;

    /* renamed from: f */
    public static final String f6901f = "sdk_int";

    /* renamed from: g */
    public static final String f6902g = "sdk";

    /* renamed from: h */
    public static final String f6903h = "release";

    /* renamed from: i */
    public static final String f6904i = "model";

    /* renamed from: j */
    public static final String f6905j = "brand";

    /* renamed from: k */
    public static final String f6906k = "netopera";

    /* renamed from: l */
    public static final String f6907l = "tags";

    /* renamed from: m */
    private int f6908m;

    /* renamed from: n */
    private String f6909n;

    /* renamed from: o */
    private String f6910o;

    /* renamed from: p */
    private String f6911p;

    /* renamed from: q */
    private String f6912q;

    /* renamed from: r */
    private String f6913r;

    /* renamed from: s */
    private String f6914s;

    /* renamed from: t */
    private Context f6915t;

    /* renamed from: u */
    private SharedPreferences f6916u;

    public static class a {

        /* renamed from: a */
        private static final bm f6917a = new bm();

        private a() {
        }
    }

    public /* synthetic */ bm(bn bnVar) {
        this();
    }

    public static bm a(Context context) {
        a.f6917a.b(context);
        return a.f6917a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() > b(f6897b).longValue()) {
                this.f6911p = Build.MODEL;
                this.f6912q = Build.BRAND;
                this.f6913r = ((TelephonyManager) this.f6915t.getSystemService("phone")).getNetworkOperator();
                this.f6914s = Build.TAGS;
                a(f6904i, this.f6911p);
                a(f6905j, this.f6912q);
                a(f6906k, this.f6913r);
                a("tags", this.f6914s);
                a(f6897b, Long.valueOf(System.currentTimeMillis() + f6899d));
            } else {
                this.f6911p = a(f6904i);
                this.f6912q = a(f6905j);
                this.f6913r = a(f6906k);
                this.f6914s = a("tags");
            }
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() > b(f6898c).longValue()) {
                int i10 = Build.VERSION.SDK_INT;
                this.f6908m = i10;
                this.f6909n = Build.VERSION.SDK;
                this.f6910o = Build.VERSION.RELEASE;
                a(f6901f, i10);
                a("sdk", this.f6909n);
                a("release", this.f6910o);
                a(f6898c, Long.valueOf(System.currentTimeMillis() + f6900e));
            } else {
                this.f6908m = c(f6901f);
                this.f6909n = a("sdk");
                this.f6910o = a("release");
            }
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.f6916u.edit();
    }

    public void b(Context context) {
        if (this.f6915t != null || context == null) {
            if (a.f6917a == null) {
                bb.a(context);
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f6915t = applicationContext;
        try {
            if (this.f6916u == null) {
                this.f6916u = applicationContext.getSharedPreferences(f6896a, 0);
                h();
            }
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
        }
    }

    public String c() {
        return this.f6910o;
    }

    public String d() {
        return this.f6911p;
    }

    public String e() {
        return this.f6912q;
    }

    public String f() {
        return this.f6913r;
    }

    public String g() {
        return this.f6914s;
    }

    private bm() {
        this.f6908m = 0;
        this.f6909n = "";
        this.f6910o = "";
        this.f6911p = "";
        this.f6912q = "";
        this.f6913r = "";
        this.f6914s = "";
    }

    private int c(String str) {
        try {
            return this.f6916u.getInt(str, 0);
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.f6908m == 0) {
            this.f6908m = Build.VERSION.SDK_INT;
        }
        return this.f6908m;
    }

    private String a(String str) {
        try {
            return this.f6916u.getString(str, "");
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k10 = k();
            k10.putString(str, str2);
            k10.apply();
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f6909n)) {
            this.f6909n = Build.VERSION.SDK;
        }
        return this.f6909n;
    }

    @TargetApi(9)
    private void a(String str, Long l10) {
        try {
            SharedPreferences.Editor k10 = k();
            k10.putLong(str, l10.longValue());
            k10.apply();
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.f6916u.getLong(str, 0L));
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i10) {
        try {
            SharedPreferences.Editor k10 = k();
            k10.putInt(str, i10);
            k10.apply();
        } catch (Throwable th2) {
            bt.a().c(th2.getMessage());
        }
    }
}
