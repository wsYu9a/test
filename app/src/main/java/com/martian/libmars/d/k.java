package com.martian.libmars.d;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private String f9895a;

    /* renamed from: c, reason: collision with root package name */
    private String f9897c;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9896b = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f9898d = false;

    /* renamed from: e, reason: collision with root package name */
    private int f9899e = 0;

    public int a() {
        return this.f9899e;
    }

    public String b() {
        return this.f9897c;
    }

    public String c() {
        return this.f9895a;
    }

    public boolean d() {
        return this.f9896b;
    }

    public boolean e() {
        return this.f9898d;
    }

    public k f(boolean downloadHint) {
        this.f9896b = downloadHint;
        return this;
    }

    public k g(boolean fullscreen) {
        this.f9898d = fullscreen;
        return this;
    }

    public k h(int orientation) {
        this.f9899e = orientation;
        return this;
    }

    public k i(String referer) {
        this.f9897c = referer;
        return this;
    }

    public k j(String url) {
        this.f9895a = url;
        return this;
    }
}
