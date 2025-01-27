package com.google.zxing.datamatrix.detector;

import a6.c;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import t5.l;
import z5.f;
import z5.h;

/* loaded from: classes2.dex */
public final class Detector {

    /* renamed from: a */
    public final z5.b f10561a;

    /* renamed from: b */
    public final c f10562b;

    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<b> {
        private ResultPointsAndTransitionsComparator() {
        }

        public /* synthetic */ ResultPointsAndTransitionsComparator(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    public static final class b {

        /* renamed from: a */
        public final l f10563a;

        /* renamed from: b */
        public final l f10564b;

        /* renamed from: c */
        public final int f10565c;

        public /* synthetic */ b(l lVar, l lVar2, int i10, a aVar) {
            this(lVar, lVar2, i10);
        }

        public l a() {
            return this.f10563a;
        }

        public l b() {
            return this.f10564b;
        }

        public int c() {
            return this.f10565c;
        }

        public String toString() {
            return this.f10563a + "/" + this.f10564b + '/' + this.f10565c;
        }

        public b(l lVar, l lVar2, int i10) {
            this.f10563a = lVar;
            this.f10564b = lVar2;
            this.f10565c = i10;
        }
    }

    public Detector(z5.b bVar) throws NotFoundException {
        this.f10561a = bVar;
        this.f10562b = new c(bVar);
    }

    public static int d(l lVar, l lVar2) {
        return a6.a.c(l.b(lVar, lVar2));
    }

    public static void e(Map<l, Integer> map, l lVar) {
        Integer num = map.get(lVar);
        map.put(lVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static z5.b g(z5.b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i10, int i11) throws NotFoundException {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return h.b().c(bVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, lVar.c(), lVar.d(), lVar4.c(), lVar4.d(), lVar3.c(), lVar3.d(), lVar2.c(), lVar2.d());
    }

    public final l a(l lVar, l lVar2, l lVar3, l lVar4, int i10) {
        float f10 = i10;
        float d10 = d(lVar, lVar2) / f10;
        float d11 = d(lVar3, lVar4);
        l lVar5 = new l(lVar4.c() + (((lVar4.c() - lVar3.c()) / d11) * d10), lVar4.d() + (d10 * ((lVar4.d() - lVar3.d()) / d11)));
        float d12 = d(lVar, lVar3) / f10;
        float d13 = d(lVar2, lVar4);
        l lVar6 = new l(lVar4.c() + (((lVar4.c() - lVar2.c()) / d13) * d12), lVar4.d() + (d12 * ((lVar4.d() - lVar2.d()) / d13)));
        if (f(lVar5)) {
            return !f(lVar6) ? lVar5 : Math.abs(h(lVar3, lVar5).c() - h(lVar2, lVar5).c()) <= Math.abs(h(lVar3, lVar6).c() - h(lVar2, lVar6).c()) ? lVar5 : lVar6;
        }
        if (f(lVar6)) {
            return lVar6;
        }
        return null;
    }

    public final l b(l lVar, l lVar2, l lVar3, l lVar4, int i10, int i11) {
        float d10 = d(lVar, lVar2) / i10;
        float d11 = d(lVar3, lVar4);
        l lVar5 = new l(lVar4.c() + (((lVar4.c() - lVar3.c()) / d11) * d10), lVar4.d() + (d10 * ((lVar4.d() - lVar3.d()) / d11)));
        float d12 = d(lVar, lVar3) / i11;
        float d13 = d(lVar2, lVar4);
        l lVar6 = new l(lVar4.c() + (((lVar4.c() - lVar2.c()) / d13) * d12), lVar4.d() + (d12 * ((lVar4.d() - lVar2.d()) / d13)));
        if (f(lVar5)) {
            return !f(lVar6) ? lVar5 : Math.abs(i10 - h(lVar3, lVar5).c()) + Math.abs(i11 - h(lVar2, lVar5).c()) <= Math.abs(i10 - h(lVar3, lVar6).c()) + Math.abs(i11 - h(lVar2, lVar6).c()) ? lVar5 : lVar6;
        }
        if (f(lVar6)) {
            return lVar6;
        }
        return null;
    }

    public f c() throws NotFoundException {
        l lVar;
        z5.b g10;
        l[] c10 = this.f10562b.c();
        l lVar2 = c10[0];
        l lVar3 = c10[1];
        l lVar4 = c10[2];
        l lVar5 = c10[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(lVar2, lVar3));
        arrayList.add(h(lVar2, lVar4));
        arrayList.add(h(lVar3, lVar5));
        arrayList.add(h(lVar4, lVar5));
        l lVar6 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        e(hashMap, bVar.a());
        e(hashMap, bVar.b());
        e(hashMap, bVar2.a());
        e(hashMap, bVar2.b());
        l lVar7 = null;
        l lVar8 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            l lVar9 = (l) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                lVar7 = lVar9;
            } else if (lVar6 == null) {
                lVar6 = lVar9;
            } else {
                lVar8 = lVar9;
            }
        }
        if (lVar6 == null || lVar7 == null || lVar8 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        l[] lVarArr = {lVar6, lVar7, lVar8};
        l.e(lVarArr);
        l lVar10 = lVarArr[0];
        l lVar11 = lVarArr[1];
        l lVar12 = lVarArr[2];
        l lVar13 = !hashMap.containsKey(lVar2) ? lVar2 : !hashMap.containsKey(lVar3) ? lVar3 : !hashMap.containsKey(lVar4) ? lVar4 : lVar5;
        int c11 = h(lVar12, lVar13).c();
        int c12 = h(lVar10, lVar13).c();
        if ((c11 & 1) == 1) {
            c11++;
        }
        int i10 = c11 + 2;
        if ((c12 & 1) == 1) {
            c12++;
        }
        int i11 = c12 + 2;
        if (i10 * 4 >= i11 * 7 || i11 * 4 >= i10 * 7) {
            lVar = lVar12;
            l b10 = b(lVar11, lVar10, lVar12, lVar13, i10, i11);
            if (b10 != null) {
                lVar13 = b10;
            }
            int c13 = h(lVar, lVar13).c();
            int c14 = h(lVar10, lVar13).c();
            if ((c13 & 1) == 1) {
                c13++;
            }
            int i12 = c13;
            if ((c14 & 1) == 1) {
                c14++;
            }
            g10 = g(this.f10561a, lVar, lVar11, lVar10, lVar13, i12, c14);
        } else {
            l a10 = a(lVar11, lVar10, lVar12, lVar13, Math.min(i11, i10));
            if (a10 != null) {
                lVar13 = a10;
            }
            int max = Math.max(h(lVar12, lVar13).c(), h(lVar10, lVar13).c());
            int i13 = max + 1;
            int i14 = (i13 & 1) == 1 ? max + 2 : i13;
            g10 = g(this.f10561a, lVar12, lVar11, lVar10, lVar13, i14, i14);
            lVar = lVar12;
        }
        return new f(g10, new l[]{lVar, lVar11, lVar10, lVar13});
    }

    public final boolean f(l lVar) {
        return lVar.c() >= 0.0f && lVar.c() < ((float) this.f10561a.l()) && lVar.d() > 0.0f && lVar.d() < ((float) this.f10561a.h());
    }

    public final b h(l lVar, l lVar2) {
        int c10 = (int) lVar.c();
        int d10 = (int) lVar.d();
        int c11 = (int) lVar2.c();
        int d11 = (int) lVar2.d();
        int i10 = 0;
        boolean z10 = Math.abs(d11 - d10) > Math.abs(c11 - c10);
        if (z10) {
            d10 = c10;
            c10 = d10;
            d11 = c11;
            c11 = d11;
        }
        int abs = Math.abs(c11 - c10);
        int abs2 = Math.abs(d11 - d10);
        int i11 = (-abs) / 2;
        int i12 = d10 < d11 ? 1 : -1;
        int i13 = c10 >= c11 ? -1 : 1;
        boolean e10 = this.f10561a.e(z10 ? d10 : c10, z10 ? c10 : d10);
        while (c10 != c11) {
            boolean e11 = this.f10561a.e(z10 ? d10 : c10, z10 ? c10 : d10);
            if (e11 != e10) {
                i10++;
                e10 = e11;
            }
            i11 += abs2;
            if (i11 > 0) {
                if (d10 == d11) {
                    break;
                }
                d10 += i12;
                i11 -= abs;
            }
            c10 += i13;
        }
        return new b(lVar, lVar2, i10);
    }
}
