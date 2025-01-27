package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class v {

    /* renamed from: h, reason: collision with root package name */
    public static JSONObject f11249h = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f11250i = "1";

    /* renamed from: j, reason: collision with root package name */
    public static final String f11251j = "2";

    /* renamed from: k, reason: collision with root package name */
    public static final String f11252k = "3";

    /* renamed from: l, reason: collision with root package name */
    public static final String f11253l = "4";

    /* renamed from: m, reason: collision with root package name */
    public static final String f11254m = "5";

    /* renamed from: n, reason: collision with root package name */
    public static final String f11255n = "6";

    /* renamed from: o, reason: collision with root package name */
    public static final String f11256o = "7";

    /* renamed from: a, reason: collision with root package name */
    public int f11257a;

    /* renamed from: b, reason: collision with root package name */
    public long f11258b;

    /* renamed from: c, reason: collision with root package name */
    public long f11259c;

    /* renamed from: d, reason: collision with root package name */
    public String f11260d;

    /* renamed from: e, reason: collision with root package name */
    public String f11261e;

    /* renamed from: f, reason: collision with root package name */
    public String f11262f;

    /* renamed from: g, reason: collision with root package name */
    public int f11263g;

    /* renamed from: p, reason: collision with root package name */
    private PackageInfo f11264p;

    /* renamed from: q, reason: collision with root package name */
    private ApplicationInfo f11265q;

    /* renamed from: r, reason: collision with root package name */
    private Context f11266r;

    public v(PackageInfo packageInfo, Context context) {
        this.f11264p = packageInfo;
        this.f11266r = context;
    }

    public int a() {
        return this.f11257a;
    }

    public String b() {
        return this.f11261e;
    }

    public String c() {
        return this.f11262f;
    }

    public long d() {
        return this.f11258b;
    }

    public String e() {
        return this.f11260d;
    }

    public long f() {
        return this.f11259c;
    }

    public int g() {
        return this.f11263g;
    }

    public void h() {
        PackageInfo packageInfo = this.f11264p;
        if (packageInfo == null && this.f11265q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f11265q != null) {
                    this.f11264p = this.f11266r.getPackageManager().getPackageInfo(this.f11265q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f11264p;
        a(packageInfo2 == null ? this.f11265q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f11264p;
        a((packageInfo3 == null ? this.f11265q : packageInfo3.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo4 = this.f11264p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f11264p.lastUpdateTime);
            c(this.f11264p.versionName);
            b(this.f11264p.versionCode);
        }
    }

    public void i() {
        PackageInfo packageInfo = this.f11264p;
        if (packageInfo == null && this.f11265q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.f11265q != null) {
                    this.f11264p = this.f11266r.getPackageManager().getPackageInfo(this.f11265q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.f11264p;
        a(packageInfo2 == null ? this.f11265q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.f11264p;
        a((packageInfo3 == null ? this.f11265q : packageInfo3.applicationInfo).flags & 1);
        PackageInfo packageInfo4 = this.f11264p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.f11264p.lastUpdateTime);
            c(this.f11264p.versionName);
            b(this.f11264p.versionCode);
        }
    }

    public String j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.f11264p;
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                ApplicationInfo applicationInfo2 = this.f11265q;
                if (applicationInfo2 != null) {
                    String charSequence = applicationInfo2.loadLabel(this.f11266r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                }
            } else {
                String charSequence2 = applicationInfo.loadLabel(this.f11266r.getPackageManager()).toString();
                if (!TextUtils.isEmpty(charSequence2)) {
                    return charSequence2;
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", c());
            jSONObject.put("2", b());
            jSONObject.put("3", e());
            jSONObject.put("4", g());
            jSONObject.put("5", a());
            jSONObject.put("6", d());
            jSONObject.put("7", f());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(int i10) {
        this.f11257a = i10;
    }

    public void b(String str) {
        this.f11262f = str;
    }

    public void c(String str) {
        this.f11260d = str;
    }

    public void a(String str) {
        this.f11261e = str;
    }

    public void b(long j10) {
        this.f11259c = j10;
    }

    public v(ApplicationInfo applicationInfo, Context context) {
        this.f11265q = applicationInfo;
        this.f11266r = context;
    }

    public void a(long j10) {
        this.f11258b = j10;
    }

    public void b(int i10) {
        this.f11263g = i10;
    }
}
