package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class bj {

    /* renamed from: a */
    public static final String f5596a = "mobads_builds";

    /* renamed from: b */
    public static final String f5597b = "brand_period";

    /* renamed from: c */
    public static final String f5598c = "version_period";

    /* renamed from: d */
    public static final long f5599d = 604800000;

    /* renamed from: e */
    public static final long f5600e = 172800000;

    /* renamed from: f */
    public static final String f5601f = "sdk_int";

    /* renamed from: g */
    public static final String f5602g = "sdk";

    /* renamed from: h */
    public static final String f5603h = "release";

    /* renamed from: i */
    public static final String f5604i = "model";

    /* renamed from: j */
    public static final String f5605j = "brand";
    public static final String k = "netopera";
    public static final String l = "tags";
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private Context t;
    private SharedPreferences u;

    private static class a {

        /* renamed from: a */
        private static final bj f5606a = new bj();

        private a() {
        }
    }

    /* synthetic */ bj(bk bkVar) {
        this();
    }

    public static bj a(Context context) {
        a.f5606a.b(context);
        return a.f5606a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() > b(f5597b).longValue()) {
                this.p = Build.MODEL;
                this.q = Build.BRAND;
                this.r = ((TelephonyManager) this.t.getSystemService("phone")).getNetworkOperator();
                this.s = Build.TAGS;
                a(f5604i, this.p);
                a(f5605j, this.q);
                a(k, this.r);
                a("tags", this.s);
                a(f5597b, Long.valueOf(System.currentTimeMillis() + f5599d));
            } else {
                this.p = a(f5604i);
                this.q = a(f5605j);
                this.r = a(k);
                this.s = a("tags");
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() > b(f5598c).longValue()) {
                int i2 = Build.VERSION.SDK_INT;
                this.m = i2;
                this.n = Build.VERSION.SDK;
                this.o = Build.VERSION.RELEASE;
                a(f5601f, i2);
                a(f5602g, this.n);
                a("release", this.o);
                a(f5598c, Long.valueOf(System.currentTimeMillis() + f5600e));
            } else {
                this.m = c(f5601f);
                this.n = a(f5602g);
                this.o = a("release");
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.u.edit();
    }

    public void b(Context context) {
        if (this.t != null || context == null) {
            if (a.f5606a == null) {
                ay.a(context);
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.t = applicationContext;
        try {
            if (this.u == null) {
                this.u = applicationContext.getSharedPreferences(f5596a, 0);
                h();
            }
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    public String c() {
        return this.o;
    }

    public String d() {
        return this.p;
    }

    public String e() {
        return this.q;
    }

    public String f() {
        return this.r;
    }

    public String g() {
        return this.s;
    }

    private bj() {
        this.m = 0;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
    }

    private int c(String str) {
        try {
            return this.u.getInt(str, 0);
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.m == 0) {
            this.m = Build.VERSION.SDK_INT;
        }
        return this.m;
    }

    private String a(String str) {
        try {
            return this.u.getString(str, "");
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putString(str, str2);
            k2.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = Build.VERSION.SDK;
        }
        return this.n;
    }

    @TargetApi(9)
    private void a(String str, Long l2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putLong(str, l2.longValue());
            k2.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.u.getLong(str, 0L));
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putInt(str, i2);
            k2.apply();
        } catch (Throwable th) {
            bq.a().c(th.getMessage());
        }
    }
}
