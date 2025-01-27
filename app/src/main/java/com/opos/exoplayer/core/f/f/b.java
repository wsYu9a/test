package com.opos.exoplayer.core.f.f;

import android.text.Layout;

/* loaded from: classes4.dex */
final class b {

    /* renamed from: a */
    private String f18717a;

    /* renamed from: b */
    private int f18718b;

    /* renamed from: c */
    private boolean f18719c;

    /* renamed from: d */
    private int f18720d;

    /* renamed from: e */
    private boolean f18721e;

    /* renamed from: f */
    private int f18722f = -1;

    /* renamed from: g */
    private int f18723g = -1;

    /* renamed from: h */
    private int f18724h = -1;

    /* renamed from: i */
    private int f18725i = -1;

    /* renamed from: j */
    private int f18726j = -1;
    private float k;
    private String l;
    private b m;
    private Layout.Alignment n;

    private b a(b bVar, boolean z) {
        if (bVar != null) {
            if (!this.f18719c && bVar.f18719c) {
                a(bVar.f18718b);
            }
            if (this.f18724h == -1) {
                this.f18724h = bVar.f18724h;
            }
            if (this.f18725i == -1) {
                this.f18725i = bVar.f18725i;
            }
            if (this.f18717a == null) {
                this.f18717a = bVar.f18717a;
            }
            if (this.f18722f == -1) {
                this.f18722f = bVar.f18722f;
            }
            if (this.f18723g == -1) {
                this.f18723g = bVar.f18723g;
            }
            if (this.n == null) {
                this.n = bVar.n;
            }
            if (this.f18726j == -1) {
                this.f18726j = bVar.f18726j;
                this.k = bVar.k;
            }
            if (z && !this.f18721e && bVar.f18721e) {
                b(bVar.f18720d);
            }
        }
        return this;
    }

    public int a() {
        int i2 = this.f18724h;
        if (i2 == -1 && this.f18725i == -1) {
            return -1;
        }
        return (this.f18725i == 1 ? 2 : 0) | (i2 == 1 ? 1 : 0);
    }

    public b a(float f2) {
        this.k = f2;
        return this;
    }

    public b a(int i2) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f18718b = i2;
        this.f18719c = true;
        return this;
    }

    public b a(Layout.Alignment alignment) {
        this.n = alignment;
        return this;
    }

    public b a(b bVar) {
        return a(bVar, true);
    }

    public b a(String str) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f18717a = str;
        return this;
    }

    public b a(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f18722f = z ? 1 : 0;
        return this;
    }

    public b b(int i2) {
        this.f18720d = i2;
        this.f18721e = true;
        return this;
    }

    public b b(String str) {
        this.l = str;
        return this;
    }

    public b b(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f18723g = z ? 1 : 0;
        return this;
    }

    public boolean b() {
        return this.f18722f == 1;
    }

    public b c(int i2) {
        this.f18726j = i2;
        return this;
    }

    public b c(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f18724h = z ? 1 : 0;
        return this;
    }

    public boolean c() {
        return this.f18723g == 1;
    }

    public b d(boolean z) {
        com.opos.exoplayer.core.i.a.b(this.m == null);
        this.f18725i = z ? 1 : 0;
        return this;
    }

    public String d() {
        return this.f18717a;
    }

    public int e() {
        if (this.f18719c) {
            return this.f18718b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public boolean f() {
        return this.f18719c;
    }

    public int g() {
        if (this.f18721e) {
            return this.f18720d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public boolean h() {
        return this.f18721e;
    }

    public String i() {
        return this.l;
    }

    public Layout.Alignment j() {
        return this.n;
    }

    public int k() {
        return this.f18726j;
    }

    public float l() {
        return this.k;
    }
}
