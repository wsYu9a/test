package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes.dex */
final class n extends p {

    /* renamed from: b */
    private final String f8615b;

    /* renamed from: c */
    private final int f8616c;

    /* renamed from: d */
    private final boolean f8617d;

    n(int i2, String str) {
        super(i2);
        this.f8615b = str;
        this.f8617d = false;
        this.f8616c = 0;
    }

    String b() {
        return this.f8615b;
    }

    int c() {
        return this.f8616c;
    }

    boolean d() {
        return this.f8617d;
    }

    n(int i2, String str, int i3) {
        super(i2);
        this.f8617d = true;
        this.f8616c = i3;
        this.f8615b = str;
    }
}
