package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class CurrentParsingState {

    /* renamed from: a, reason: collision with root package name */
    private int f8592a = 0;

    /* renamed from: b, reason: collision with root package name */
    private State f8593b = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    int a() {
        return this.f8592a;
    }

    void b(int i2) {
        this.f8592a += i2;
    }

    boolean c() {
        return this.f8593b == State.ALPHA;
    }

    boolean d() {
        return this.f8593b == State.ISO_IEC_646;
    }

    boolean e() {
        return this.f8593b == State.NUMERIC;
    }

    void f() {
        this.f8593b = State.ALPHA;
    }

    void g() {
        this.f8593b = State.ISO_IEC_646;
    }

    void h() {
        this.f8593b = State.NUMERIC;
    }

    void i(int i2) {
        this.f8592a = i2;
    }
}
