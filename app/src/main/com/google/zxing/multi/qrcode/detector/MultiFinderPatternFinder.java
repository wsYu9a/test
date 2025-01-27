package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import l5.c;
import t5.l;
import t5.m;
import u6.d;
import u6.e;
import z5.b;

/* loaded from: classes2.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* renamed from: i */
    public static final e[] f10568i = new e[0];

    /* renamed from: j */
    public static final float f10569j = 180.0f;

    /* renamed from: k */
    public static final float f10570k = 9.0f;

    /* renamed from: l */
    public static final float f10571l = 0.05f;

    /* renamed from: m */
    public static final float f10572m = 0.5f;

    public static final class ModuleSizeComparator implements Serializable, Comparator<d> {
        private ModuleSizeComparator() {
        }

        public /* synthetic */ ModuleSizeComparator(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            double i10 = dVar2.i() - dVar.i();
            if (i10 < c.f27899e) {
                return -1;
            }
            return i10 > c.f27899e ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(b bVar) {
        super(bVar);
    }

    public e[] n(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z11 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        b i10 = i();
        int h10 = i10.h();
        int l10 = i10.l();
        int i11 = (int) ((h10 / 228.0f) * 3.0f);
        if (i11 < 3 || z10) {
            i11 = 3;
        }
        int[] iArr = new int[5];
        for (int i12 = i11 - 1; i12 < h10; i12 += i11) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < l10; i14++) {
                if (i10.e(i14, i12)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) != 0) {
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 != 4) {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                } else if (FinderPatternFinder.g(iArr) && k(iArr, i12, i14, z11)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i13 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i13 = 3;
                }
            }
            if (FinderPatternFinder.g(iArr)) {
                k(iArr, i12, l10, z11);
            }
        }
        d[][] o10 = o();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : o10) {
            l.e(dVarArr);
            arrayList.add(new e(dVarArr));
        }
        return arrayList.isEmpty() ? f10568i : (e[]) arrayList.toArray(new e[arrayList.size()]);
    }

    public final d[][] o() throws NotFoundException {
        char c10 = 0;
        List<d> j10 = j();
        int size = j10.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size == 3) {
            return new d[][]{new d[]{j10.get(0), j10.get(1), j10.get(2)}};
        }
        Collections.sort(j10, new ModuleSizeComparator());
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < size - 2) {
            d dVar = j10.get(i10);
            if (dVar != null) {
                int i11 = i10 + 1;
                while (i11 < size - 1) {
                    d dVar2 = j10.get(i11);
                    if (dVar2 != null) {
                        float i12 = (dVar.i() - dVar2.i()) / Math.min(dVar.i(), dVar2.i());
                        float f10 = 0.05f;
                        float f11 = 0.5f;
                        if (Math.abs(dVar.i() - dVar2.i()) > 0.5f && i12 >= 0.05f) {
                            break;
                        }
                        int i13 = i11 + 1;
                        while (i13 < size) {
                            d dVar3 = j10.get(i13);
                            if (dVar3 != null) {
                                float i14 = (dVar2.i() - dVar3.i()) / Math.min(dVar2.i(), dVar3.i());
                                if (Math.abs(dVar2.i() - dVar3.i()) > f11 && i14 >= f10) {
                                    break;
                                }
                                d[] dVarArr = new d[3];
                                dVarArr[c10] = dVar;
                                dVarArr[1] = dVar2;
                                dVarArr[2] = dVar3;
                                l.e(dVarArr);
                                e eVar = new e(dVarArr);
                                float b10 = l.b(eVar.b(), eVar.a());
                                float b11 = l.b(eVar.c(), eVar.a());
                                float b12 = l.b(eVar.b(), eVar.c());
                                float i15 = (b10 + b12) / (dVar.i() * 2.0f);
                                if (i15 <= 180.0f && i15 >= 9.0f && Math.abs((b10 - b12) / Math.min(b10, b12)) < 0.1f) {
                                    float sqrt = (float) Math.sqrt((b10 * b10) + (b12 * b12));
                                    if (Math.abs((b11 - sqrt) / Math.min(b11, sqrt)) < 0.1f) {
                                        arrayList.add(dVarArr);
                                    }
                                }
                            }
                            i13++;
                            c10 = 0;
                            f10 = 0.05f;
                            f11 = 0.5f;
                        }
                    }
                    i11++;
                    c10 = 0;
                }
            }
            i10++;
            c10 = 0;
        }
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (d[][]) arrayList.toArray(new d[arrayList.size()][]);
    }

    public MultiFinderPatternFinder(b bVar, m mVar) {
        super(bVar, mVar);
    }
}
