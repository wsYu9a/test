package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private final a f8357a;

    /* renamed from: b */
    private final List<b> f8358b;

    public d(a aVar) {
        this.f8357a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f8358b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i2) {
        if (i2 >= this.f8358b.size()) {
            List<b> list = this.f8358b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.f8358b.size(); size <= i2; size++) {
                a aVar = this.f8357a;
                bVar = bVar.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f8358b.add(bVar);
            }
        }
        return this.f8358b.get(i2);
    }

    public void b(int[] iArr, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i2;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a2 = a(i2);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] e2 = new b(this.f8357a, iArr2).j(i2, 1).b(a2)[1].e();
        int length2 = i2 - e2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            iArr[length + i3] = 0;
        }
        System.arraycopy(e2, 0, iArr, length + length2, e2.length);
    }
}
