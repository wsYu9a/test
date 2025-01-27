package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.l6;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class w6 {

    /* renamed from: a */
    public final List<byte[]> f28250a;

    /* renamed from: b */
    public final int f28251b;

    /* renamed from: c */
    public final int f28252c;

    /* renamed from: d */
    public final int f28253d;

    /* renamed from: e */
    public final float f28254e;

    public w6(List<byte[]> list, int i2, int i3, int i4, float f2) {
        this.f28250a = list;
        this.f28251b = i2;
        this.f28252c = i3;
        this.f28253d = i4;
        this.f28254e = f2;
    }

    public static byte[] a(n6 n6Var) {
        int q = n6Var.q();
        int i2 = n6Var.f27875b;
        n6Var.e(q);
        byte[] bArr = n6Var.f27874a;
        byte[] bArr2 = f6.f27417a;
        byte[] bArr3 = new byte[bArr2.length + q];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, q);
        return bArr3;
    }

    public static w6 b(n6 n6Var) {
        int i2;
        int i3;
        float f2;
        try {
            n6Var.e(4);
            int l = (n6Var.l() & 3) + 1;
            if (l == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int l2 = n6Var.l() & 31;
            for (int i4 = 0; i4 < l2; i4++) {
                arrayList.add(a(n6Var));
            }
            int l3 = n6Var.l();
            for (int i5 = 0; i5 < l3; i5++) {
                arrayList.add(a(n6Var));
            }
            if (l2 > 0) {
                l6.b b2 = l6.b((byte[]) arrayList.get(0), l, ((byte[]) arrayList.get(0)).length);
                int i6 = b2.f27734b;
                int i7 = b2.f27735c;
                f2 = b2.f27736d;
                i2 = i6;
                i3 = i7;
            } else {
                i2 = -1;
                i3 = -1;
                f2 = 1.0f;
            }
            return new w6(arrayList, l, i2, i3, f2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new f("Error parsing AVC config", e2);
        }
    }
}
