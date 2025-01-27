package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* loaded from: classes.dex */
final class w {

    /* renamed from: a */
    private static final int[] f8636a = {1, 1, 2};

    /* renamed from: b */
    private final u f8637b = new u();

    /* renamed from: c */
    private final v f8638c = new v();

    w() {
    }

    com.google.zxing.k a(int i2, com.google.zxing.common.a aVar, int i3) throws NotFoundException {
        int[] n = x.n(aVar, i3, false, f8636a);
        try {
            return this.f8638c.b(i2, aVar, n);
        } catch (ReaderException unused) {
            return this.f8637b.b(i2, aVar, n);
        }
    }
}
