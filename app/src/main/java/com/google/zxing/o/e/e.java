package com.google.zxing.o.e;

import kotlin.text.Typography;

/* loaded from: classes.dex */
final class e extends g {

    /* renamed from: c */
    private final short f8493c;

    /* renamed from: d */
    private final short f8494d;

    e(g gVar, int i2, int i3) {
        super(gVar);
        this.f8493c = (short) i2;
        this.f8494d = (short) i3;
    }

    @Override // com.google.zxing.o.e.g
    void c(com.google.zxing.common.a aVar, byte[] bArr) {
        aVar.c(this.f8493c, this.f8494d);
    }

    public String toString() {
        short s = this.f8493c;
        short s2 = this.f8494d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f8494d)).substring(1) + Typography.greater;
    }
}
