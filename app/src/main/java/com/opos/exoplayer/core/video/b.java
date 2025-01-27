package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.i.k;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public final List<byte[]> f19224a;

    /* renamed from: b */
    public final int f19225b;

    private b(List<byte[]> list, int i2) {
        this.f19224a = list;
        this.f19225b = i2;
    }

    public static b a(m mVar) {
        try {
            mVar.d(21);
            int g2 = mVar.g();
            int g3 = mVar.g();
            int d2 = mVar.d();
            int i2 = 0;
            for (int i3 = 0; i3 < g3; i3++) {
                mVar.d(1);
                int h2 = mVar.h();
                for (int i4 = 0; i4 < h2; i4++) {
                    int h3 = mVar.h();
                    i2 += h3 + 4;
                    mVar.d(h3);
                }
            }
            mVar.c(d2);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < g3; i6++) {
                mVar.d(1);
                int h4 = mVar.h();
                for (int i7 = 0; i7 < h4; i7++) {
                    int h5 = mVar.h();
                    byte[] bArr2 = k.f19027a;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(mVar.f19048a, mVar.d(), bArr, length, h5);
                    i5 = length + h5;
                    mVar.d(h5);
                }
            }
            return new b(i2 == 0 ? null : Collections.singletonList(bArr), (g2 & 3) + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new o("Error parsing HEVC config", e2);
        }
    }
}
