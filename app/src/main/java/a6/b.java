package a6;

import com.google.zxing.NotFoundException;
import t5.l;

@Deprecated
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b */
    public static final int f73b = 32;

    /* renamed from: a */
    public final z5.b f74a;

    public b(z5.b bVar) {
        this.f74a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0068 A[EDGE_INSN: B:67:0x0068->B:47:0x0068 BREAK  A[LOOP:3: B:39:0x0053->B:61:0x0053], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0031 A[EDGE_INSN: B:81:0x0031->B:21:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:75:0x001c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] a(int r5, int r6, int r7, int r8, boolean r9) {
        /*
            r4 = this;
            int r0 = r7 + r8
            int r0 = r0 / 2
            r1 = r0
        L5:
            if (r1 < r7) goto L3a
            z5.b r2 = r4.f74a
            if (r9 == 0) goto L12
            boolean r2 = r2.e(r1, r5)
            if (r2 == 0) goto L1b
            goto L18
        L12:
            boolean r2 = r2.e(r5, r1)
            if (r2 == 0) goto L1b
        L18:
            int r1 = r1 + (-1)
            goto L5
        L1b:
            r2 = r1
        L1c:
            int r2 = r2 + (-1)
            if (r2 < r7) goto L31
            z5.b r3 = r4.f74a
            if (r9 == 0) goto L2b
            boolean r3 = r3.e(r2, r5)
            if (r3 == 0) goto L1c
            goto L31
        L2b:
            boolean r3 = r3.e(r5, r2)
            if (r3 == 0) goto L1c
        L31:
            int r3 = r1 - r2
            if (r2 < r7) goto L3a
            if (r3 <= r6) goto L38
            goto L3a
        L38:
            r1 = r2
            goto L5
        L3a:
            int r1 = r1 + 1
        L3c:
            if (r0 >= r8) goto L71
            z5.b r7 = r4.f74a
            if (r9 == 0) goto L49
            boolean r7 = r7.e(r0, r5)
            if (r7 == 0) goto L52
            goto L4f
        L49:
            boolean r7 = r7.e(r5, r0)
            if (r7 == 0) goto L52
        L4f:
            int r0 = r0 + 1
            goto L3c
        L52:
            r7 = r0
        L53:
            int r7 = r7 + 1
            if (r7 >= r8) goto L68
            z5.b r2 = r4.f74a
            if (r9 == 0) goto L62
            boolean r2 = r2.e(r7, r5)
            if (r2 == 0) goto L53
            goto L68
        L62:
            boolean r2 = r2.e(r5, r7)
            if (r2 == 0) goto L53
        L68:
            int r2 = r7 - r0
            if (r7 >= r8) goto L71
            if (r2 <= r6) goto L6f
            goto L71
        L6f:
            r0 = r7
            goto L3c
        L71:
            int r0 = r0 + (-1)
            if (r0 <= r1) goto L7a
            int[] r5 = new int[]{r1, r0}
            return r5
        L7a:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.b.a(int, int, int, int, boolean):int[]");
    }

    public l[] b() throws NotFoundException {
        int h10 = this.f74a.h();
        int l10 = this.f74a.l();
        int i10 = h10 / 2;
        int i11 = l10 / 2;
        int max = Math.max(1, h10 / 256);
        int max2 = Math.max(1, l10 / 256);
        int i12 = -max;
        int i13 = i11 / 2;
        int d10 = ((int) c(i11, 0, 0, l10, i10, i12, 0, h10, i13).d()) - 1;
        int i14 = i10 / 2;
        l c10 = c(i11, -max2, 0, l10, i10, 0, d10, h10, i14);
        int c11 = ((int) c10.c()) - 1;
        l c12 = c(i11, max2, c11, l10, i10, 0, d10, h10, i14);
        int c13 = ((int) c12.c()) + 1;
        l c14 = c(i11, 0, c11, c13, i10, max, d10, h10, i13);
        return new l[]{c(i11, 0, c11, c13, i10, i12, d10, ((int) c14.d()) + 1, i11 / 4), c10, c12, c14};
    }

    public final l c(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) throws NotFoundException {
        int[] iArr = null;
        int i19 = i10;
        int i20 = i14;
        while (i20 < i17 && i20 >= i16 && i19 < i13 && i19 >= i12) {
            int[] a10 = i11 == 0 ? a(i20, i18, i12, i13, true) : a(i19, i18, i16, i17, false);
            if (a10 == null) {
                if (iArr == null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i11 == 0) {
                    int i21 = i20 - i15;
                    int i22 = iArr[0];
                    if (i22 >= i10) {
                        return new l(iArr[1], i21);
                    }
                    if (iArr[1] > i10) {
                        return new l(iArr[i15 <= 0 ? (char) 1 : (char) 0], i21);
                    }
                    return new l(i22, i21);
                }
                int i23 = i19 - i11;
                int i24 = iArr[0];
                if (i24 >= i14) {
                    return new l(i23, iArr[1]);
                }
                if (iArr[1] > i14) {
                    return new l(i23, iArr[i11 >= 0 ? (char) 1 : (char) 0]);
                }
                return new l(i23, i24);
            }
            i20 += i15;
            i19 += i11;
            iArr = a10;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
