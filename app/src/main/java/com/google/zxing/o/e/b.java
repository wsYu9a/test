package com.google.zxing.o.e;

import kotlin.text.Typography;

/* loaded from: classes.dex */
final class b extends g {

    /* renamed from: c */
    private final short f8475c;

    /* renamed from: d */
    private final short f8476d;

    b(g gVar, int i2, int i3) {
        super(gVar);
        this.f8475c = (short) i2;
        this.f8476d = (short) i3;
    }

    @Override // com.google.zxing.o.e.g
    public void c(com.google.zxing.common.a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f8476d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                aVar.c(31, 5);
                short s2 = this.f8476d;
                if (s2 > 62) {
                    aVar.c(s2 - 31, 16);
                } else if (i2 == 0) {
                    aVar.c(Math.min((int) s2, 31), 5);
                } else {
                    aVar.c(s2 - 31, 5);
                }
            }
            aVar.c(bArr[this.f8475c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f8475c);
        sb.append("::");
        sb.append((this.f8475c + this.f8476d) - 1);
        sb.append(Typography.greater);
        return sb.toString();
    }
}
