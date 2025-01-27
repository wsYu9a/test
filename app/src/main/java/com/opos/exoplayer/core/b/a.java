package com.opos.exoplayer.core.b;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    private int f17716a;

    public void a() {
        this.f17716a = 0;
    }

    public final void a_(int i2) {
        this.f17716a = i2;
    }

    public final void b(int i2) {
        this.f17716a = i2 | this.f17716a;
    }

    public final void c(int i2) {
        this.f17716a = (i2 ^ (-1)) & this.f17716a;
    }

    public final boolean c() {
        return d(4);
    }

    public final boolean d() {
        return d(1);
    }

    protected final boolean d(int i2) {
        return (this.f17716a & i2) == i2;
    }

    public final boolean d_() {
        return d(Integer.MIN_VALUE);
    }
}
