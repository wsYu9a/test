package com.vivo.ad.model;

/* loaded from: classes4.dex */
public class x {

    /* renamed from: a */
    private int f26939a;

    /* renamed from: b */
    private int f26940b;

    /* renamed from: c */
    private int f26941c;

    /* renamed from: d */
    private String f26942d;

    /* renamed from: e */
    private String f26943e;

    /* renamed from: f */
    private String f26944f;

    /* renamed from: g */
    private String f26945g;

    public int a() {
        return this.f26939a;
    }

    public int b() {
        return this.f26940b;
    }

    public void c(int i2) {
        if (i2 < 18) {
            this.f26941c = 18;
        } else if (i2 > 20) {
            this.f26941c = 20;
        } else {
            this.f26941c = i2;
        }
    }

    public int d() {
        return this.f26941c;
    }

    public String e() {
        return this.f26943e;
    }

    public String f() {
        return this.f26945g;
    }

    public String g() {
        return this.f26944f;
    }

    public void a(int i2) {
        if (i2 < 24) {
            this.f26939a = 24;
        } else if (i2 > 30) {
            this.f26939a = 30;
        } else {
            this.f26939a = i2;
        }
    }

    public void b(int i2) {
        if (i2 < 14) {
            this.f26940b = 14;
        } else if (i2 > 18) {
            this.f26940b = 18;
        } else {
            this.f26940b = i2;
        }
    }

    public void d(String str) {
        this.f26944f = str;
    }

    public String c() {
        return this.f26942d;
    }

    public void a(String str) {
        this.f26942d = str;
    }

    public void b(String str) {
        this.f26943e = str;
    }

    public void c(String str) {
        this.f26945g = str;
    }
}
