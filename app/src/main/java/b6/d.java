package b6;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a */
    public final a f1302a;

    /* renamed from: b */
    public final List<b> f1303b;

    public d(a aVar) {
        this.f1302a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f1303b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    public final b a(int i10) {
        if (i10 >= this.f1303b.size()) {
            List<b> list = this.f1303b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.f1303b.size(); size <= i10; size++) {
                a aVar = this.f1302a;
                bVar = bVar.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f1303b.add(bVar);
            }
        }
        return this.f1303b.get(i10);
    }

    public void b(int[] iArr, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i10;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a10 = a(i10);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] e10 = new b(this.f1302a, iArr2).j(i10, 1).b(a10)[1].e();
        int length2 = i10 - e10.length;
        for (int i11 = 0; i11 < length2; i11++) {
            iArr[length + i11] = 0;
        }
        System.arraycopy(e10, 0, iArr, length + length2, e10.length);
    }
}
