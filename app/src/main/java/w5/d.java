package w5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c */
    public static final int f31582c = 0;

    /* renamed from: d */
    public static final int f31583d = 1;

    /* renamed from: e */
    public static final int f31584e = 2;

    /* renamed from: f */
    public static final int f31585f = 3;

    /* renamed from: g */
    public static final int f31586g = 4;

    /* renamed from: i */
    public static final int[][] f31588i;

    /* renamed from: j */
    public static final int[][] f31589j;

    /* renamed from: a */
    public final byte[] f31590a;

    /* renamed from: b */
    public static final String[] f31581b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: h */
    public static final int[][] f31587h = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    public class a implements Comparator<f> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.d() - fVar2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        f31588i = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            f31588i[0][i10] = i10 - 63;
        }
        f31588i[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            f31588i[1][i11] = i11 - 95;
        }
        f31588i[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            f31588i[2][i12] = i12 - 46;
        }
        int[] iArr2 = f31588i[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        int i13 = 0;
        for (int i14 = 28; i13 < i14; i14 = 28) {
            f31588i[3][iArr3[i13]] = i13;
            i13++;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i15 = 0; i15 < 31; i15++) {
            int i16 = iArr4[i15];
            if (i16 > 0) {
                f31588i[4][i16] = i15;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        f31589j = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f31589j;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public d(byte[] bArr) {
        this.f31590a = bArr;
    }

    public static Collection<f> b(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedList.add(fVar);
                    break;
                }
                f fVar2 = (f) it.next();
                if (fVar2.g(fVar)) {
                    break;
                }
                if (fVar.g(fVar2)) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }

    public static void d(f fVar, int i10, int i11, Collection<f> collection) {
        f b10 = fVar.b(i10);
        collection.add(b10.h(4, i11));
        if (fVar.e() != 4) {
            collection.add(b10.i(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(b10.h(2, 16 - i11).h(2, 1));
        }
        if (fVar.c() > 0) {
            collection.add(fVar.a(i10).a(i10 + 1));
        }
    }

    public static Collection<f> f(Iterable<f> iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i10, i11, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z5.a a() {
        /*
            r8 = this;
            w5.f r0 = w5.f.f31594e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = 0
        L8:
            byte[] r3 = r8.f31590a
            int r4 = r3.length
            if (r2 >= r4) goto L4c
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L15
            r5 = r3[r4]
            goto L16
        L15:
            r5 = 0
        L16:
            r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L38
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L34
            r6 = 46
            if (r3 == r6) goto L30
            r6 = 58
            if (r3 == r6) goto L2c
        L2a:
            r3 = 0
            goto L3d
        L2c:
            if (r5 != r7) goto L2a
            r3 = 5
            goto L3d
        L30:
            if (r5 != r7) goto L2a
            r3 = 3
            goto L3d
        L34:
            if (r5 != r7) goto L2a
            r3 = 4
            goto L3d
        L38:
            r3 = 10
            if (r5 != r3) goto L2a
            r3 = 2
        L3d:
            if (r3 <= 0) goto L45
            java.util.Collection r0 = f(r0, r2, r3)
            r2 = r4
            goto L49
        L45:
            java.util.Collection r0 = r8.e(r0, r2)
        L49:
            int r2 = r2 + 1
            goto L8
        L4c:
            w5.d$a r1 = new w5.d$a
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            w5.f r0 = (w5.f) r0
            byte[] r1 = r8.f31590a
            z5.a r0 = r0.j(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.d.a():z5.a");
    }

    public final void c(f fVar, int i10, Collection<f> collection) {
        char c10 = (char) (this.f31590a[i10] & 255);
        boolean z10 = f31588i[fVar.e()][c10] > 0;
        f fVar2 = null;
        for (int i11 = 0; i11 <= 4; i11++) {
            int i12 = f31588i[i11][c10];
            if (i12 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.b(i10);
                }
                if (!z10 || i11 == fVar.e() || i11 == 2) {
                    collection.add(fVar2.h(i11, i12));
                }
                if (!z10 && f31589j[fVar.e()][i11] >= 0) {
                    collection.add(fVar2.i(i11, i12));
                }
            }
        }
        if (fVar.c() > 0 || f31588i[fVar.e()][c10] == 0) {
            collection.add(fVar.a(i10));
        }
    }

    public final Collection<f> e(Iterable<f> iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i10, linkedList);
        }
        return b(linkedList);
    }
}
