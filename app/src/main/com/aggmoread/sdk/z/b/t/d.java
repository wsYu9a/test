package com.aggmoread.sdk.z.b.t;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public String f4944b;

    /* renamed from: c, reason: collision with root package name */
    public String f4945c;

    /* renamed from: d, reason: collision with root package name */
    public String f4946d;

    /* renamed from: e, reason: collision with root package name */
    public String f4947e;

    /* renamed from: g, reason: collision with root package name */
    public int f4949g;

    /* renamed from: i, reason: collision with root package name */
    public String f4951i;

    /* renamed from: j, reason: collision with root package name */
    public String f4952j;

    /* renamed from: k, reason: collision with root package name */
    public String f4953k;

    /* renamed from: l, reason: collision with root package name */
    public String f4954l;

    /* renamed from: m, reason: collision with root package name */
    public String f4955m;

    /* renamed from: n, reason: collision with root package name */
    public int f4956n;

    /* renamed from: f, reason: collision with root package name */
    public int f4948f = 1;

    /* renamed from: h, reason: collision with root package name */
    public int f4950h = 0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4957o = true;

    public d() {
        new ArrayList();
    }

    public String a() {
        return TextUtils.isEmpty(this.f4946d) ? this.f4945c : this.f4946d;
    }

    public String b() {
        return this.f4947e;
    }

    public String c() {
        return TextUtils.isEmpty(this.f4945c) ? this.f4946d : this.f4945c;
    }

    public String d() {
        return TextUtils.isEmpty(this.f4955m) ? a() : this.f4955m;
    }

    public String e() {
        return this.f4952j;
    }

    public String f() {
        return TextUtils.isEmpty(this.f4954l) ? c() : this.f4954l;
    }

    public String g() {
        return TextUtils.isEmpty(this.f4953k) ? this.f4947e : this.f4953k;
    }

    public int h() {
        return this.f4956n;
    }

    public int i() {
        if (this.f4948f == 1) {
            return this.f4949g;
        }
        return 0;
    }

    public String j() {
        return this.f4944b;
    }

    public boolean k() {
        return this.f4950h == 1;
    }
}
