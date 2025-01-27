package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* loaded from: classes.dex */
final class o extends p {

    /* renamed from: b */
    static final int f8618b = 10;

    /* renamed from: c */
    private final int f8619c;

    /* renamed from: d */
    private final int f8620d;

    o(int i2, int i3, int i4) throws FormatException {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.f8619c = i3;
        this.f8620d = i4;
    }

    int b() {
        return this.f8619c;
    }

    int c() {
        return this.f8620d;
    }

    int d() {
        return (this.f8619c * 10) + this.f8620d;
    }

    boolean e() {
        return this.f8619c == 10 || this.f8620d == 10;
    }

    boolean f() {
        return this.f8619c == 10;
    }

    boolean g() {
        return this.f8620d == 10;
    }
}
