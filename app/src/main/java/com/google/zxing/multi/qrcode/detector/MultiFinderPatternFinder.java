package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.l;
import com.google.zxing.m;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.d;
import com.google.zxing.qrcode.detector.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* renamed from: i */
    private static final e[] f8454i = new e[0];

    /* renamed from: j */
    private static final float f8455j = 180.0f;
    private static final float k = 9.0f;
    private static final float l = 0.05f;
    private static final float m = 0.5f;

    private static final class ModuleSizeComparator implements Serializable, Comparator<d> {
        private ModuleSizeComparator() {
        }

        /* synthetic */ ModuleSizeComparator(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            double i2 = dVar2.i() - dVar.i();
            if (i2 < 0.0d) {
                return -1;
            }
            return i2 > 0.0d ? 1 : 0;
        }
    }

    MultiFinderPatternFinder(b bVar) {
        super(bVar);
    }

    private d[][] o() throws NotFoundException {
        List<d> j2 = j();
        int size = j2.size();
        int i2 = 3;
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        char c2 = 0;
        if (size == 3) {
            return new d[][]{new d[]{j2.get(0), j2.get(1), j2.get(2)}};
        }
        Collections.sort(j2, new ModuleSizeComparator());
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < size - 2) {
            d dVar = j2.get(i3);
            if (dVar != null) {
                int i4 = i3 + 1;
                while (i4 < size - 1) {
                    d dVar2 = j2.get(i4);
                    if (dVar2 != null) {
                        float i5 = (dVar.i() - dVar2.i()) / Math.min(dVar.i(), dVar2.i());
                        float f2 = 0.05f;
                        float f3 = 0.5f;
                        if (Math.abs(dVar.i() - dVar2.i()) <= 0.5f || i5 < 0.05f) {
                            int i6 = i4 + 1;
                            while (i6 < size) {
                                d dVar3 = j2.get(i6);
                                if (dVar3 != null) {
                                    float i7 = (dVar2.i() - dVar3.i()) / Math.min(dVar2.i(), dVar3.i());
                                    if (Math.abs(dVar2.i() - dVar3.i()) <= f3 || i7 < f2) {
                                        d[] dVarArr = new d[i2];
                                        dVarArr[c2] = dVar;
                                        dVarArr[1] = dVar2;
                                        dVarArr[2] = dVar3;
                                        l.e(dVarArr);
                                        e eVar = new e(dVarArr);
                                        float b2 = l.b(eVar.b(), eVar.a());
                                        float b3 = l.b(eVar.c(), eVar.a());
                                        float b4 = l.b(eVar.b(), eVar.c());
                                        float i8 = (b2 + b4) / (dVar.i() * 2.0f);
                                        if (i8 <= f8455j && i8 >= k && Math.abs((b2 - b4) / Math.min(b2, b4)) < 0.1f) {
                                            float sqrt = (float) Math.sqrt((b2 * b2) + (b4 * b4));
                                            if (Math.abs((b3 - sqrt) / Math.min(b3, sqrt)) < 0.1f) {
                                                arrayList.add(dVarArr);
                                            }
                                        }
                                    }
                                }
                                i6++;
                                i2 = 3;
                                c2 = 0;
                                f2 = 0.05f;
                                f3 = 0.5f;
                            }
                        }
                    }
                    i4++;
                    i2 = 3;
                    c2 = 0;
                }
            }
            i3++;
            i2 = 3;
            c2 = 0;
        }
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
    }

    public e[] n(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        b i2 = i();
        int h2 = i2.h();
        int l2 = i2.l();
        int i3 = (int) ((h2 / 228.0f) * 3.0f);
        if (i3 < 3 || z) {
            i3 = 3;
        }
        int[] iArr = new int[5];
        for (int i4 = i3 - 1; i4 < h2; i4 += i3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < l2; i6++) {
                if (i2.e(i6, i4)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (FinderPatternFinder.g(iArr) && k(iArr, i4, i6, z2)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i5 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i5 = 3;
                }
            }
            if (FinderPatternFinder.g(iArr)) {
                k(iArr, i4, l2, z2);
            }
        }
        d[][] o = o();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : o) {
            l.e(dVarArr);
            arrayList.add(new e(dVarArr));
        }
        return arrayList.isEmpty() ? f8454i : (e[]) arrayList.toArray(new e[arrayList.size()]);
    }

    MultiFinderPatternFinder(b bVar, m mVar) {
        super(bVar, mVar);
    }
}
