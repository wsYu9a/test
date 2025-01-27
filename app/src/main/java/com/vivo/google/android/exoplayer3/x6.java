package com.vivo.google.android.exoplayer3;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class x6 {

    /* renamed from: a */
    public final List<byte[]> f28274a;

    /* renamed from: b */
    public final int f28275b;

    public x6(List<byte[]> list, int i2) {
        this.f28274a = list;
        this.f28275b = i2;
    }

    public static x6 a(n6 n6Var) {
        try {
            n6Var.e(21);
            int l = n6Var.l() & 3;
            int l2 = n6Var.l();
            int i2 = n6Var.f27875b;
            int i3 = 0;
            for (int i4 = 0; i4 < l2; i4++) {
                n6Var.e(1);
                int q = n6Var.q();
                for (int i5 = 0; i5 < q; i5++) {
                    int q2 = n6Var.q();
                    i3 += q2 + 4;
                    n6Var.e(q2);
                }
            }
            n6Var.d(i2);
            byte[] bArr = new byte[i3];
            int i6 = 0;
            for (int i7 = 0; i7 < l2; i7++) {
                n6Var.e(1);
                int q3 = n6Var.q();
                for (int i8 = 0; i8 < q3; i8++) {
                    int q4 = n6Var.q();
                    byte[] bArr2 = l6.f27726a;
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    int length = i6 + bArr2.length;
                    System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, length, q4);
                    i6 = length + q4;
                    n6Var.e(q4);
                }
            }
            return new x6(i3 == 0 ? null : Collections.singletonList(bArr), l + 1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new f("Error parsing HEVC config", e2);
        }
    }
}
