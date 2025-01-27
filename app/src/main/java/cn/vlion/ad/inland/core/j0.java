package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.util.config.VlionTimeConfig;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a */
    public String f3672a;

    /* renamed from: b */
    public float f3673b;

    /* renamed from: c */
    public float f3674c;

    /* renamed from: d */
    public int f3675d;

    /* renamed from: e */
    public float f3676e = 5.0f;

    /* renamed from: f */
    public int f3677f = 4;

    /* renamed from: g */
    public boolean f3678g = false;

    /* renamed from: h */
    public int f3679h;

    public final int a() {
        return this.f3675d;
    }

    public final float b() {
        return this.f3674c;
    }

    public final int c() {
        return this.f3677f;
    }

    public final int d() {
        return this.f3679h;
    }

    public final String e() {
        return this.f3672a;
    }

    public final float f() {
        return this.f3676e;
    }

    public final float g() {
        return this.f3673b;
    }

    public final boolean h() {
        return this.f3678g;
    }

    public final void a(float f10) {
        this.f3674c = f10;
    }

    public final void b(float f10) {
        this.f3676e = VlionTimeConfig.getMaxTolerateTime(f10);
    }

    public final void c(float f10) {
        this.f3673b = f10;
    }

    public final void a(int i10) {
        this.f3675d = i10;
    }

    public final void b(int i10) {
        this.f3677f = i10;
    }

    public final void c(int i10) {
        this.f3679h = i10;
    }

    public final void a(String str) {
        this.f3672a = str;
    }

    public final void a(boolean z10) {
        this.f3678g = z10;
    }
}
