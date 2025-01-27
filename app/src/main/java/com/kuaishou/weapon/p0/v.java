package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class v {

    /* renamed from: h, reason: collision with root package name */
    public static JSONObject f9424h = null;

    /* renamed from: i, reason: collision with root package name */
    public static final String f9425i = "1";

    /* renamed from: j, reason: collision with root package name */
    public static final String f9426j = "2";
    public static final String k = "3";
    public static final String l = "4";
    public static final String m = "5";
    public static final String n = "6";
    public static final String o = "7";

    /* renamed from: a, reason: collision with root package name */
    public int f9427a;

    /* renamed from: b, reason: collision with root package name */
    public long f9428b;

    /* renamed from: c, reason: collision with root package name */
    public long f9429c;

    /* renamed from: d, reason: collision with root package name */
    public String f9430d;

    /* renamed from: e, reason: collision with root package name */
    public String f9431e;

    /* renamed from: f, reason: collision with root package name */
    public String f9432f;

    /* renamed from: g, reason: collision with root package name */
    public int f9433g;
    private PackageInfo p;
    private ApplicationInfo q;
    private Context r;

    public v(ApplicationInfo applicationInfo, Context context) {
        this.q = applicationInfo;
        this.r = context;
    }

    public v(PackageInfo packageInfo, Context context) {
        this.p = packageInfo;
        this.r = context;
    }

    public int a() {
        return this.f9427a;
    }

    public void a(int i2) {
        this.f9427a = i2;
    }

    public void a(long j2) {
        this.f9428b = j2;
    }

    public void a(String str) {
        this.f9431e = str;
    }

    public String b() {
        return this.f9431e;
    }

    public void b(int i2) {
        this.f9433g = i2;
    }

    public void b(long j2) {
        this.f9429c = j2;
    }

    public void b(String str) {
        this.f9432f = str;
    }

    public String c() {
        return this.f9432f;
    }

    public void c(String str) {
        this.f9430d = str;
    }

    public long d() {
        return this.f9428b;
    }

    public String e() {
        return this.f9430d;
    }

    public long f() {
        return this.f9429c;
    }

    public int g() {
        return this.f9433g;
    }

    public void h() {
        PackageInfo packageInfo = this.p;
        if (packageInfo == null && this.q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.q != null) {
                    this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.p;
        a(packageInfo2 == null ? this.q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.p;
        a((packageInfo3 == null ? this.q : packageInfo3.applicationInfo).flags & 1);
        b(j());
        PackageInfo packageInfo4 = this.p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.p.lastUpdateTime);
            c(this.p.versionName);
            b(this.p.versionCode);
        }
    }

    public void i() {
        PackageInfo packageInfo = this.p;
        if (packageInfo == null && this.q == null) {
            return;
        }
        if (packageInfo == null) {
            try {
                if (this.q != null) {
                    this.p = this.r.getPackageManager().getPackageInfo(this.q.packageName, 0);
                }
            } catch (Exception unused) {
            }
        }
        PackageInfo packageInfo2 = this.p;
        a(packageInfo2 == null ? this.q.packageName : packageInfo2.packageName);
        PackageInfo packageInfo3 = this.p;
        a((packageInfo3 == null ? this.q : packageInfo3.applicationInfo).flags & 1);
        PackageInfo packageInfo4 = this.p;
        if (packageInfo4 != null) {
            a(packageInfo4.firstInstallTime);
            b(this.p.lastUpdateTime);
            c(this.p.versionName);
            b(this.p.versionCode);
        }
    }

    public String j() {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = this.p;
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                ApplicationInfo applicationInfo2 = this.q;
                if (applicationInfo2 != null) {
                    String charSequence = applicationInfo2.loadLabel(this.r.getPackageManager()).toString();
                    if (!TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                }
            } else {
                String charSequence2 = applicationInfo.loadLabel(this.r.getPackageManager()).toString();
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
}
