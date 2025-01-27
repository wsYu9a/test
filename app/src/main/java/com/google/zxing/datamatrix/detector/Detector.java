package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.f;
import com.google.zxing.common.h;
import com.google.zxing.common.l.c;
import com.google.zxing.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Detector {

    /* renamed from: a */
    private final com.google.zxing.common.b f8384a;

    /* renamed from: b */
    private final c f8385b;

    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<b> {
        private ResultPointsAndTransitionsComparator() {
        }

        /* synthetic */ ResultPointsAndTransitionsComparator(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    private static final class b {

        /* renamed from: a */
        private final l f8386a;

        /* renamed from: b */
        private final l f8387b;

        /* renamed from: c */
        private final int f8388c;

        /* synthetic */ b(l lVar, l lVar2, int i2, a aVar) {
            this(lVar, lVar2, i2);
        }

        l a() {
            return this.f8386a;
        }

        l b() {
            return this.f8387b;
        }

        int c() {
            return this.f8388c;
        }

        public String toString() {
            return this.f8386a + "/" + this.f8387b + '/' + this.f8388c;
        }

        private b(l lVar, l lVar2, int i2) {
            this.f8386a = lVar;
            this.f8387b = lVar2;
            this.f8388c = i2;
        }
    }

    public Detector(com.google.zxing.common.b bVar) throws NotFoundException {
        this.f8384a = bVar;
        this.f8385b = new c(bVar);
    }

    private l a(l lVar, l lVar2, l lVar3, l lVar4, int i2) {
        float f2 = i2;
        float d2 = d(lVar, lVar2) / f2;
        float d3 = d(lVar3, lVar4);
        l lVar5 = new l(lVar4.c() + (((lVar4.c() - lVar3.c()) / d3) * d2), lVar4.d() + (d2 * ((lVar4.d() - lVar3.d()) / d3)));
        float d4 = d(lVar, lVar3) / f2;
        float d5 = d(lVar2, lVar4);
        l lVar6 = new l(lVar4.c() + (((lVar4.c() - lVar2.c()) / d5) * d4), lVar4.d() + (d4 * ((lVar4.d() - lVar2.d()) / d5)));
        if (f(lVar5)) {
            return (f(lVar6) && Math.abs(h(lVar3, lVar5).c() - h(lVar2, lVar5).c()) > Math.abs(h(lVar3, lVar6).c() - h(lVar2, lVar6).c())) ? lVar6 : lVar5;
        }
        if (f(lVar6)) {
            return lVar6;
        }
        return null;
    }

    private l b(l lVar, l lVar2, l lVar3, l lVar4, int i2, int i3) {
        float d2 = d(lVar, lVar2) / i2;
        float d3 = d(lVar3, lVar4);
        l lVar5 = new l(lVar4.c() + (((lVar4.c() - lVar3.c()) / d3) * d2), lVar4.d() + (d2 * ((lVar4.d() - lVar3.d()) / d3)));
        float d4 = d(lVar, lVar3) / i3;
        float d5 = d(lVar2, lVar4);
        l lVar6 = new l(lVar4.c() + (((lVar4.c() - lVar2.c()) / d5) * d4), lVar4.d() + (d4 * ((lVar4.d() - lVar2.d()) / d5)));
        if (f(lVar5)) {
            return (f(lVar6) && Math.abs(i2 - h(lVar3, lVar5).c()) + Math.abs(i3 - h(lVar2, lVar5).c()) > Math.abs(i2 - h(lVar3, lVar6).c()) + Math.abs(i3 - h(lVar2, lVar6).c())) ? lVar6 : lVar5;
        }
        if (f(lVar6)) {
            return lVar6;
        }
        return null;
    }

    private static int d(l lVar, l lVar2) {
        return com.google.zxing.common.l.a.c(l.b(lVar, lVar2));
    }

    private static void e(Map<l, Integer> map, l lVar) {
        Integer num = map.get(lVar);
        map.put(lVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(l lVar) {
        return lVar.c() >= 0.0f && lVar.c() < ((float) this.f8384a.l()) && lVar.d() > 0.0f && lVar.d() < ((float) this.f8384a.h());
    }

    private static com.google.zxing.common.b g(com.google.zxing.common.b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i2, int i3) throws NotFoundException {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return h.b().c(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, lVar.c(), lVar.d(), lVar4.c(), lVar4.d(), lVar3.c(), lVar3.d(), lVar2.c(), lVar2.d());
    }

    private b h(l lVar, l lVar2) {
        int c2 = (int) lVar.c();
        int d2 = (int) lVar.d();
        int c3 = (int) lVar2.c();
        int d3 = (int) lVar2.d();
        int i2 = 0;
        boolean z = Math.abs(d3 - d2) > Math.abs(c3 - c2);
        if (z) {
            d2 = c2;
            c2 = d2;
            d3 = c3;
            c3 = d3;
        }
        int abs = Math.abs(c3 - c2);
        int abs2 = Math.abs(d3 - d2);
        int i3 = (-abs) / 2;
        int i4 = d2 < d3 ? 1 : -1;
        int i5 = c2 >= c3 ? -1 : 1;
        boolean e2 = this.f8384a.e(z ? d2 : c2, z ? c2 : d2);
        while (c2 != c3) {
            boolean e3 = this.f8384a.e(z ? d2 : c2, z ? c2 : d2);
            if (e3 != e2) {
                i2++;
                e2 = e3;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (d2 == d3) {
                    break;
                }
                d2 += i4;
                i3 -= abs;
            }
            c2 += i5;
        }
        return new b(lVar, lVar2, i2);
    }

    public f c() throws NotFoundException {
        l lVar;
        com.google.zxing.common.b g2;
        l[] c2 = this.f8385b.c();
        l lVar2 = c2[0];
        l lVar3 = c2[1];
        l lVar4 = c2[2];
        l lVar5 = c2[3];
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
        int c3 = h(lVar12, lVar13).c();
        int c4 = h(lVar10, lVar13).c();
        if ((c3 & 1) == 1) {
            c3++;
        }
        int i2 = c3 + 2;
        if ((c4 & 1) == 1) {
            c4++;
        }
        int i3 = c4 + 2;
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            lVar = lVar12;
            l b2 = b(lVar11, lVar10, lVar12, lVar13, i2, i3);
            if (b2 != null) {
                lVar13 = b2;
            }
            int c5 = h(lVar, lVar13).c();
            int c6 = h(lVar10, lVar13).c();
            if ((c5 & 1) == 1) {
                c5++;
            }
            int i4 = c5;
            if ((c6 & 1) == 1) {
                c6++;
            }
            g2 = g(this.f8384a, lVar, lVar11, lVar10, lVar13, i4, c6);
        } else {
            l a2 = a(lVar11, lVar10, lVar12, lVar13, Math.min(i3, i2));
            if (a2 != null) {
                lVar13 = a2;
            }
            int max = Math.max(h(lVar12, lVar13).c(), h(lVar10, lVar13).c()) + 1;
            if ((max & 1) == 1) {
                max++;
            }
            int i5 = max;
            g2 = g(this.f8384a, lVar12, lVar11, lVar10, lVar13, i5, i5);
            lVar = lVar12;
        }
        return new f(g2, new l[]{lVar, lVar11, lVar10, lVar13});
    }
}
