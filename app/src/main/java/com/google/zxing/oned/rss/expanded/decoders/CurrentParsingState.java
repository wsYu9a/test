package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
public final class CurrentParsingState {

    /* renamed from: a, reason: collision with root package name */
    public int f10586a = 0;

    /* renamed from: b, reason: collision with root package name */
    public State f10587b = State.NUMERIC;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    public int a() {
        return this.f10586a;
    }

    public void b(int i10) {
        this.f10586a += i10;
    }

    public boolean c() {
        return this.f10587b == State.ALPHA;
    }

    public boolean d() {
        return this.f10587b == State.ISO_IEC_646;
    }

    public boolean e() {
        return this.f10587b == State.NUMERIC;
    }

    public void f() {
        this.f10587b = State.ALPHA;
    }

    public void g() {
        this.f10587b = State.ISO_IEC_646;
    }

    public void h() {
        this.f10587b = State.NUMERIC;
    }

    public void i(int i10) {
        this.f10586a = i10;
    }
}
