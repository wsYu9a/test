package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.l;
import com.google.zxing.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FinderPatternFinder {

    /* renamed from: a */
    private static final int f8770a = 2;

    /* renamed from: b */
    protected static final int f8771b = 3;

    /* renamed from: c */
    protected static final int f8772c = 57;

    /* renamed from: d */
    private final com.google.zxing.common.b f8773d;

    /* renamed from: e */
    private final List<d> f8774e;

    /* renamed from: f */
    private boolean f8775f;

    /* renamed from: g */
    private final int[] f8776g;

    /* renamed from: h */
    private final m f8777h;

    private static final class CenterComparator implements Serializable, Comparator<d> {
        private final float average;

        /* synthetic */ CenterComparator(float f2, a aVar) {
            this(f2);
        }

        private CenterComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            if (dVar2.h() != dVar.h()) {
                return dVar2.h() - dVar.h();
            }
            float abs = Math.abs(dVar2.i() - this.average);
            float abs2 = Math.abs(dVar.i() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<d> {
        private final float average;

        /* synthetic */ FurthestFromAverageComparator(float f2, a aVar) {
            this(f2);
        }

        private FurthestFromAverageComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(d dVar, d dVar2) {
            float abs = Math.abs(dVar2.i() - this.average);
            float abs2 = Math.abs(dVar.i() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(com.google.zxing.common.b bVar) {
        this(bVar, null);
    }

    private static float a(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002a, code lost:
    
        if (r18 >= r6) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r17 < r6) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r18 < r6) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (r16.f8773d.e(r18 - r6, r17 - r6) != false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        if (r4[1] > r19) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        r4[1] = r4[1] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r17 < r6) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r18 < r6) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0050, code lost:
    
        if (r4[1] <= r19) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r17 < r6) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r18 < r6) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0062, code lost:
    
        if (r16.f8773d.e(r18 - r6, r17 - r6) == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        if (r4[0] > r19) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        r4[0] = r4[0] + 1;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        if (r4[0] <= r19) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        r6 = r16.f8773d.h();
        r9 = r16.f8773d.l();
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
    
        if (r11 >= r6) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r12 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        if (r12 >= r9) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0090, code lost:
    
        if (r16.f8773d.e(r12, r11) == false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0092, code lost:
    
        r4[2] = r4[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
    
        if (r11 >= r6) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009e, code lost:
    
        if ((r18 + r10) < r9) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a2, code lost:
    
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
    
        if (r11 >= r6) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a7, code lost:
    
        r13 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a9, code lost:
    
        if (r13 >= r9) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b1, code lost:
    
        if (r16.f8773d.e(r13, r11) != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b5, code lost:
    
        if (r4[3] >= r19) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b7, code lost:
    
        r4[3] = r4[3] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bf, code lost:
    
        if (r11 >= r6) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c3, code lost:
    
        if ((r18 + r10) >= r9) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c7, code lost:
    
        if (r4[3] < r19) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ca, code lost:
    
        r11 = r17 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00cd, code lost:
    
        if (r11 >= r6) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cf, code lost:
    
        r14 = r18 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00d1, code lost:
    
        if (r14 >= r9) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d9, code lost:
    
        if (r16.f8773d.e(r14, r11) == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
    
        if (r4[4] >= r19) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00df, code lost:
    
        r4[4] = r4[4] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00e9, code lost:
    
        if (r4[4] < r19) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00eb, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0102, code lost:
    
        if (java.lang.Math.abs(((((r4[0] + r4[1]) + r4[2]) + r4[3]) + r4[4]) - r20) >= (r20 * 2)) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0108, code lost:
    
        if (g(r4) == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x010a, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(int r17, int r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.b(int, int, int, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.e(r3, r12) == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.e(r11, r12) == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.e(r11, r12) != false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.e(r11, r12) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b7, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < r14) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00be, code lost:
    
        if (g(r2) == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c4, code lost:
    
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float c(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.c(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2[1] <= r13) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r3 < 0) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0.e(r12, r3) == false) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
    
        if (r2[0] > r13) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
    
        r2[0] = r2[0] + 1;
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        if (r2[0] <= r13) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        if (r11 >= r1) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005f, code lost:
    
        if (r0.e(r12, r11) == false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0061, code lost:
    
        r2[2] = r2[2] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0069, code lost:
    
        if (r11 != r1) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x006d, code lost:
    
        if (r11 >= r1) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0073, code lost:
    
        if (r0.e(r12, r11) != false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (r2[3] >= r13) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0079, code lost:
    
        r2[3] = r2[3] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r11 == r1) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0085, code lost:
    
        if (r2[3] < r13) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0089, code lost:
    
        if (r11 >= r1) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008f, code lost:
    
        if (r0.e(r12, r11) == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0093, code lost:
    
        if (r2[4] >= r13) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0095, code lost:
    
        r2[4] = r2[4] + 1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009f, code lost:
    
        if (r2[4] < r13) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a1, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b9, code lost:
    
        if ((java.lang.Math.abs(((((r2[0] + r2[1]) + r2[2]) + r2[3]) + r2[4]) - r14) * 5) < (r14 * 2)) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c0, code lost:
    
        if (g(r2) == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c6, code lost:
    
        return a(r2, r11);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float d(int r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.d(int, int, int, int):float");
    }

    private int f() {
        if (this.f8774e.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f8774e) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f8775f = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    protected static boolean g(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = i2 / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    private int[] h() {
        int[] iArr = this.f8776g;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean l() {
        int size = this.f8774e.size();
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        for (d dVar : this.f8774e) {
            if (dVar.h() >= 2) {
                i2++;
                f3 += dVar.i();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f4 = f3 / size;
        Iterator<d> it = this.f8774e.iterator();
        while (it.hasNext()) {
            f2 += Math.abs(it.next().i() - f4);
        }
        return f2 <= f3 * 0.05f;
    }

    private d[] m() throws NotFoundException {
        int size = this.f8774e.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float f2 = 0.0f;
        if (size > 3) {
            Iterator<d> it = this.f8774e.iterator();
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (it.hasNext()) {
                float i2 = it.next().i();
                f3 += i2;
                f4 += i2 * i2;
            }
            float f5 = f3 / size;
            float sqrt = (float) Math.sqrt((f4 / r0) - (f5 * f5));
            Collections.sort(this.f8774e, new FurthestFromAverageComparator(f5));
            float max = Math.max(0.2f * f5, sqrt);
            int i3 = 0;
            while (i3 < this.f8774e.size() && this.f8774e.size() > 3) {
                if (Math.abs(this.f8774e.get(i3).i() - f5) > max) {
                    this.f8774e.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
        if (this.f8774e.size() > 3) {
            Iterator<d> it2 = this.f8774e.iterator();
            while (it2.hasNext()) {
                f2 += it2.next().i();
            }
            Collections.sort(this.f8774e, new CenterComparator(f2 / this.f8774e.size()));
            List<d> list = this.f8774e;
            list.subList(3, list.size()).clear();
        }
        return new d[]{this.f8774e.get(0), this.f8774e.get(1), this.f8774e.get(2)};
    }

    final e e(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int h2 = this.f8773d.h();
        int l = this.f8773d.l();
        int i2 = (h2 * 3) / 228;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean z3 = false;
        while (i3 < h2 && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < l) {
                if (this.f8773d.e(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 == 4) {
                    if (!g(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (k(iArr, i3, i4, z2)) {
                        if (this.f8775f) {
                            z3 = l();
                        } else {
                            int f2 = f();
                            if (f2 > iArr[2]) {
                                i3 += (f2 - iArr[2]) - 2;
                                i4 = l - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i2 = 2;
                        i5 = 0;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i5 = 3;
                } else {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                }
                i4++;
            }
            if (g(iArr) && k(iArr, i3, l, z2)) {
                i2 = iArr[0];
                if (this.f8775f) {
                    z3 = l();
                }
            }
            i3 += i2;
        }
        d[] m = m();
        l.e(m);
        return new e(m);
    }

    protected final com.google.zxing.common.b i() {
        return this.f8773d;
    }

    protected final List<d> j() {
        return this.f8774e;
    }

    protected final boolean k(int[] iArr, int i2, int i3, boolean z) {
        boolean z2 = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i3);
        float d2 = d(i2, a2, iArr[2], i4);
        if (!Float.isNaN(d2)) {
            int i5 = (int) d2;
            float c2 = c(a2, i5, iArr[2], i4);
            if (!Float.isNaN(c2) && (!z || b(i5, (int) c2, iArr[2], i4))) {
                float f2 = i4 / 7.0f;
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f8774e.size()) {
                        break;
                    }
                    d dVar = this.f8774e.get(i6);
                    if (dVar.f(f2, d2, c2)) {
                        this.f8774e.set(i6, dVar.g(d2, c2, f2));
                        z2 = true;
                        break;
                    }
                    i6++;
                }
                if (!z2) {
                    d dVar2 = new d(c2, d2, f2);
                    this.f8774e.add(dVar2);
                    m mVar = this.f8777h;
                    if (mVar != null) {
                        mVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public FinderPatternFinder(com.google.zxing.common.b bVar, m mVar) {
        this.f8773d = bVar;
        this.f8774e = new ArrayList();
        this.f8776g = new int[5];
        this.f8777h = mVar;
    }
}
