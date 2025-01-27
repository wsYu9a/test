package com.google.zxing.s;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.j;
import com.google.zxing.k;
import com.google.zxing.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a */
    private static final int f8816a = 100;

    /* renamed from: b */
    private static final int f8817b = 4;

    /* renamed from: c */
    private final j f8818c;

    public b(j jVar) {
        this.f8818c = jVar;
    }

    private void a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map, List<k> list, int i2, int i3, int i4) {
        boolean z;
        float f2;
        float f3;
        int i5;
        int i6;
        if (i4 > 4) {
            return;
        }
        try {
            k a2 = this.f8818c.a(bVar, map);
            Iterator<k> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g().equals(a2.g())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                list.add(c(a2, i2, i3));
            }
            l[] f4 = a2.f();
            if (f4 == null || f4.length == 0) {
                return;
            }
            int e2 = bVar.e();
            int d2 = bVar.d();
            float f5 = e2;
            float f6 = d2;
            float f7 = 0.0f;
            float f8 = 0.0f;
            for (l lVar : f4) {
                if (lVar != null) {
                    float c2 = lVar.c();
                    float d3 = lVar.d();
                    if (c2 < f5) {
                        f5 = c2;
                    }
                    if (d3 < f6) {
                        f6 = d3;
                    }
                    if (c2 > f7) {
                        f7 = c2;
                    }
                    if (d3 > f8) {
                        f8 = d3;
                    }
                }
            }
            if (f5 > 100.0f) {
                f2 = f7;
                f3 = f6;
                i5 = d2;
                i6 = e2;
                a(bVar.a(0, 0, (int) f5, d2), map, list, i2, i3, i4 + 1);
            } else {
                f2 = f7;
                f3 = f6;
                i5 = d2;
                i6 = e2;
            }
            if (f3 > 100.0f) {
                a(bVar.a(0, 0, i6, (int) f3), map, list, i2, i3, i4 + 1);
            }
            float f9 = f2;
            if (f9 < i6 - 100) {
                int i7 = (int) f9;
                a(bVar.a(i7, 0, i6 - i7, i5), map, list, i2 + i7, i3, i4 + 1);
            }
            if (f8 < i5 - 100) {
                int i8 = (int) f8;
                a(bVar.a(0, i8, i6, i5 - i8), map, list, i2, i3 + i8, i4 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    private static k c(k kVar, int i2, int i3) {
        l[] f2 = kVar.f();
        if (f2 == null) {
            return kVar;
        }
        l[] lVarArr = new l[f2.length];
        for (int i4 = 0; i4 < f2.length; i4++) {
            l lVar = f2[i4];
            if (lVar != null) {
                lVarArr[i4] = new l(lVar.c() + i2, lVar.d() + i3);
            }
        }
        k kVar2 = new k(kVar.g(), kVar.d(), kVar.c(), lVarArr, kVar.b(), kVar.h());
        kVar2.i(kVar.e());
        return kVar2;
    }

    @Override // com.google.zxing.s.c
    public k[] b(com.google.zxing.b bVar) throws NotFoundException {
        return d(bVar, null);
    }

    @Override // com.google.zxing.s.c
    public k[] d(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        a(bVar, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }
}
