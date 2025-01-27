package com.vivo.mobilead.b;

import android.text.TextUtils;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.util.x0;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private long f28659a;

    /* renamed from: b */
    private String f28660b;

    /* renamed from: c */
    private long f28661c;

    /* renamed from: d */
    private int f28662d;

    /* renamed from: e */
    private int f28663e;

    /* renamed from: f */
    private String f28664f;

    /* renamed from: g */
    private String f28665g;

    /* renamed from: h */
    private String f28666h;

    /* renamed from: i */
    private String f28667i;

    /* renamed from: j */
    private int f28668j;
    private int k;
    private String l;
    private String m;
    private String n;
    private a.EnumC0603a o;
    private int p;

    public c(String str, String str2) {
        this.k = 0;
        this.f28660b = str;
        this.f28664f = str2;
        this.f28661c = System.currentTimeMillis();
        this.f28662d = 1;
        this.f28663e = 0;
        this.f28659a = -1L;
    }

    public void a(int i2) {
        this.p = i2;
    }

    public int b() {
        return this.p;
    }

    public String c() {
        if (!TextUtils.isEmpty(this.f28660b) && this.f28660b.contains("cfrom=")) {
            int indexOf = this.f28660b.indexOf("cfrom=") + 6;
            int i2 = indexOf + 3;
            if (i2 > this.f28660b.length() - 1) {
                this.l = this.f28660b.substring(indexOf);
            } else {
                this.l = this.f28660b.substring(indexOf, i2);
            }
            x0.a("ReportData", "cfrom::" + this.l);
        }
        return this.l;
    }

    public long d() {
        return this.f28661c;
    }

    public void e(String str) {
        this.m = str;
    }

    public int f() {
        return this.f28668j;
    }

    public String g() {
        return this.n;
    }

    public String h() {
        return this.f28666h;
    }

    public int i() {
        return this.f28662d;
    }

    public a.EnumC0603a j() {
        return this.o;
    }

    public String k() {
        return this.f28665g;
    }

    public String l() {
        return this.f28667i;
    }

    public int m() {
        return this.f28663e;
    }

    public long n() {
        return this.f28659a;
    }

    public String o() {
        return TextUtils.isEmpty(this.m) ? "" : this.m;
    }

    public String p() {
        return this.f28660b;
    }

    public String toString() {
        return "ReportData{mRowID=" + this.f28659a + ", mUrl='" + this.f28660b + "', mCreateTime=" + this.f28661c + ", mReportFlag=" + this.f28662d + ", mRetryTimes=" + this.f28663e + ", mAdCoop='" + this.f28664f + "', mReqID='" + this.f28665g + "', mPosID='" + this.f28666h + "', resultDetails='" + this.f28667i + "', mLevel=" + this.f28668j + ", mIsThirdReport=" + this.k + ", cfrom='" + this.l + "', mSourceAppend='" + this.m + "'}";
    }

    public void a(String str) {
        this.n = str;
    }

    public void b(String str) {
        this.f28666h = str;
    }

    public void d(int i2) {
        this.f28663e = i2;
    }

    public int e() {
        return this.k;
    }

    public void a(a.EnumC0603a enumC0603a) {
        this.o = enumC0603a;
    }

    public void b(int i2) {
        this.k = i2;
    }

    public void d(String str) {
        this.f28667i = str;
    }

    public void a(long j2) {
        this.f28659a = j2;
    }

    public String a() {
        return this.f28664f;
    }

    public static String a(String str, Map<String, String> map) {
        if (map == null) {
            return str;
        }
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (!TextUtils.isEmpty(str3)) {
                str = com.vivo.mobilead.manager.c.a(str, str2, str3);
            }
        }
        return str;
    }

    public void c(String str) {
        this.f28665g = str;
    }

    public c(String str, String str2, long j2, int i2, int i3, long j3) {
        this.k = 0;
        this.f28660b = str;
        this.f28664f = str2;
        this.f28661c = j2;
        this.f28662d = i2;
        this.f28663e = i3;
        this.f28659a = j3;
    }

    public void c(int i2) {
        this.f28668j = i2;
    }
}
