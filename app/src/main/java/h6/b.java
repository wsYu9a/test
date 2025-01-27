package h6;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t5.j;
import t5.k;
import t5.l;

/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: b */
    public static final int f26500b = 100;

    /* renamed from: c */
    public static final int f26501c = 4;

    /* renamed from: a */
    public final j f26502a;

    public b(j jVar) {
        this.f26502a = jVar;
    }

    public static k b(k kVar, int i10, int i11) {
        l[] f10 = kVar.f();
        if (f10 == null) {
            return kVar;
        }
        l[] lVarArr = new l[f10.length];
        for (int i12 = 0; i12 < f10.length; i12++) {
            l lVar = f10[i12];
            if (lVar != null) {
                lVarArr[i12] = new l(lVar.c() + i10, lVar.d() + i11);
            }
        }
        k kVar2 = new k(kVar.g(), kVar.d(), kVar.c(), lVarArr, kVar.b(), kVar.h());
        kVar2.i(kVar.e());
        return kVar2;
    }

    public final void a(t5.b bVar, Map<DecodeHintType, ?> map, List<k> list, int i10, int i11, int i12) {
        float f10;
        float f11;
        float f12;
        int i13;
        if (i12 > 4) {
            return;
        }
        try {
            k a10 = this.f26502a.a(bVar, map);
            Iterator<k> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g().equals(a10.g())) {
                        break;
                    }
                } else {
                    list.add(b(a10, i10, i11));
                    break;
                }
            }
            l[] f13 = a10.f();
            if (f13 == null || f13.length == 0) {
                return;
            }
            int e10 = bVar.e();
            int d10 = bVar.d();
            float f14 = e10;
            float f15 = 0.0f;
            float f16 = d10;
            float f17 = 0.0f;
            for (l lVar : f13) {
                if (lVar != null) {
                    float c10 = lVar.c();
                    float d11 = lVar.d();
                    if (c10 < f14) {
                        f14 = c10;
                    }
                    if (d11 < f16) {
                        f16 = d11;
                    }
                    if (c10 > f15) {
                        f15 = c10;
                    }
                    if (d11 > f17) {
                        f17 = d11;
                    }
                }
            }
            if (f14 > 100.0f) {
                f10 = f17;
                f11 = f15;
                f12 = f16;
                i13 = 0;
                a(bVar.a(0, 0, (int) f14, d10), map, list, i10, i11, i12 + 1);
            } else {
                f10 = f17;
                f11 = f15;
                f12 = f16;
                i13 = 0;
            }
            if (f12 > 100.0f) {
                a(bVar.a(i13, i13, e10, (int) f12), map, list, i10, i11, i12 + 1);
            }
            if (f11 < e10 - 100) {
                int i14 = (int) f11;
                a(bVar.a(i14, i13, e10 - i14, d10), map, list, i10 + i14, i11, i12 + 1);
            }
            if (f10 < d10 - 100) {
                int i15 = (int) f10;
                a(bVar.a(i13, i15, e10, d10 - i15), map, list, i10, i11 + i15, i12 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    @Override // h6.c
    public k[] c(t5.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        a(bVar, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (k[]) arrayList.toArray(new k[arrayList.size()]);
    }

    @Override // h6.c
    public k[] d(t5.b bVar) throws NotFoundException {
        return c(bVar, null);
    }
}
