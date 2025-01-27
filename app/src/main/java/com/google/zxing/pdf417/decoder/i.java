package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.l;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a */
    private static final int f8700a = 2;

    /* renamed from: b */
    private static final int f8701b = 3;

    /* renamed from: c */
    private static final int f8702c = 512;

    /* renamed from: d */
    private static final com.google.zxing.pdf417.decoder.j.a f8703d = new com.google.zxing.pdf417.decoder.j.a();

    private i() {
    }

    private static c a(g gVar) throws NotFoundException {
        int[] j2;
        if (gVar == null || (j2 = gVar.j()) == null) {
            return null;
        }
        int p = p(j2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : j2) {
            i3 += p - i4;
            if (i4 > 0) {
                break;
            }
        }
        d[] d2 = gVar.d();
        for (int i5 = 0; i3 > 0 && d2[i5] == null; i5++) {
            i3--;
        }
        for (int length = j2.length - 1; length >= 0; length--) {
            i2 += p - j2[length];
            if (j2[length] > 0) {
                break;
            }
        }
        for (int length2 = d2.length - 1; i2 > 0 && d2[length2] == null; length2--) {
            i2--;
        }
        return gVar.a().a(i3, i2, gVar.k());
    }

    private static void b(e eVar, b[][] bVarArr) throws NotFoundException {
        int[] b2 = bVarArr[0][1].b();
        int j2 = (eVar.j() * eVar.l()) - r(eVar.k());
        if (b2.length != 0) {
            if (b2[0] != j2) {
                bVarArr[0][1].c(j2);
            }
        } else {
            if (j2 <= 0 || j2 > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVarArr[0][1].c(j2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int c(com.google.zxing.common.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.e(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.c(com.google.zxing.common.b, int, int, boolean, int, int):int");
    }

    private static boolean d(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    private static int e(int[] iArr, int[] iArr2, int i2) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return f8703d.a(iArr, i2, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static b[][] f(e eVar) {
        int c2;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.l(), eVar.j() + 2);
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                bVarArr[i2][i3] = new b();
            }
        }
        int i4 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (c2 = dVar.c()) >= 0 && c2 < bVarArr.length) {
                        bVarArr[c2][i4].c(dVar.e());
                    }
                }
            }
            i4++;
        }
        return bVarArr;
    }

    private static com.google.zxing.common.d g(e eVar) throws FormatException, ChecksumException, NotFoundException {
        b[][] f2 = f(eVar);
        b(eVar, f2);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < eVar.l(); i2++) {
            int i3 = 0;
            while (i3 < eVar.j()) {
                int i4 = i3 + 1;
                int[] b2 = f2[i2][i4].b();
                int j2 = (eVar.j() * i2) + i3;
                if (b2.length == 0) {
                    arrayList.add(Integer.valueOf(j2));
                } else if (b2.length == 1) {
                    iArr[j2] = b2[0];
                } else {
                    arrayList3.add(Integer.valueOf(j2));
                    arrayList2.add(b2);
                }
                i3 = i4;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return h(eVar.k(), iArr, com.google.zxing.t.a.c(arrayList), com.google.zxing.t.a.c(arrayList3), iArr2);
    }

    private static com.google.zxing.common.d h(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i5 = 0; i5 < length; i5++) {
                iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
            }
            try {
                return j(iArr, i2, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    if (iArr5[i6] < iArr4[i6].length - 1) {
                        iArr5[i6] = iArr5[i6] + 1;
                        break;
                    }
                    iArr5[i6] = 0;
                    if (i6 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    i6++;
                }
                i3 = i4;
            }
        }
    }

    public static com.google.zxing.common.d i(com.google.zxing.common.b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i2, int i3) throws NotFoundException, FormatException, ChecksumException {
        int i4;
        int i5;
        int i6;
        g gVar = null;
        g gVar2 = null;
        e eVar = null;
        c cVar = new c(bVar, lVar, lVar2, lVar3, lVar4);
        for (int i7 = 0; i7 < 2; i7++) {
            if (lVar != null) {
                gVar = s(bVar, cVar, lVar, true, i2, i3);
            }
            if (lVar3 != null) {
                gVar2 = s(bVar, cVar, lVar3, false, i2, i3);
            }
            eVar = v(gVar, gVar2);
            if (eVar == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i7 != 0 || eVar.m() == null || (eVar.m().h() >= cVar.h() && eVar.m().f() <= cVar.f())) {
                eVar.p(cVar);
                break;
            }
            cVar = eVar.m();
        }
        int j2 = eVar.j() + 1;
        eVar.q(0, gVar);
        eVar.q(j2, gVar2);
        boolean z = gVar != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= j2; i10++) {
            int i11 = z ? i10 : j2 - i10;
            if (eVar.n(i11) == null) {
                f gVar3 = (i11 == 0 || i11 == j2) ? new g(cVar, i11 == 0) : new f(cVar);
                eVar.q(i11, gVar3);
                int i12 = -1;
                int h2 = cVar.h();
                int i13 = -1;
                while (h2 <= cVar.f()) {
                    int t = t(eVar, i11, h2, z);
                    if (t >= 0 && t <= cVar.e()) {
                        i6 = t;
                    } else if (i13 != i12) {
                        i6 = i13;
                    } else {
                        i4 = i13;
                        i5 = h2;
                        i13 = i4;
                        h2 = i5 + 1;
                        i12 = -1;
                    }
                    i4 = i13;
                    int i14 = h2;
                    d k = k(bVar, cVar.g(), cVar.e(), z, i6, i14, i8, i9);
                    i5 = i14;
                    if (k != null) {
                        gVar3.f(i5, k);
                        i8 = Math.min(i8, k.f());
                        i9 = Math.max(i9, k.f());
                        i13 = i6;
                        h2 = i5 + 1;
                        i12 = -1;
                    }
                    i13 = i4;
                    h2 = i5 + 1;
                    i12 = -1;
                }
            }
        }
        return g(eVar);
    }

    private static com.google.zxing.common.d j(int[] iArr, int i2, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i3 = 1 << (i2 + 1);
        int e2 = e(iArr, iArr2, i3);
        x(iArr, i3);
        com.google.zxing.common.d b2 = DecodedBitStreamParser.b(iArr, String.valueOf(i2));
        b2.m(Integer.valueOf(e2));
        b2.l(Integer.valueOf(iArr2.length));
        return b2;
    }

    private static d k(com.google.zxing.common.b bVar, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int d2;
        int b2;
        int c2 = c(bVar, i2, i3, z, i4, i5);
        int[] q = q(bVar, i2, i3, z, c2, i5);
        if (q == null) {
            return null;
        }
        int d3 = com.google.zxing.common.l.a.d(q);
        if (z) {
            i8 = c2 + d3;
        } else {
            for (int i9 = 0; i9 < q.length / 2; i9++) {
                int i10 = q[i9];
                q[i9] = q[(q.length - 1) - i9];
                q[(q.length - 1) - i9] = i10;
            }
            c2 -= d3;
            i8 = c2;
        }
        if (d(d3, i6, i7) && (b2 = com.google.zxing.t.a.b((d2 = h.d(q)))) != -1) {
            return new d(c2, i8, n(d2), b2);
        }
        return null;
    }

    private static a l(g gVar, g gVar2) {
        a i2;
        a i3;
        if (gVar == null || (i2 = gVar.i()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.i();
        }
        if (gVar2 == null || (i3 = gVar2.i()) == null || i2.a() == i3.a() || i2.b() == i3.b() || i2.c() == i3.c()) {
            return i2;
        }
        return null;
    }

    private static int[] m(int i2) {
        int[] iArr = new int[8];
        int i3 = 0;
        int i4 = 7;
        while (true) {
            int i5 = i2 & 1;
            if (i5 != i3) {
                i4--;
                if (i4 < 0) {
                    return iArr;
                }
                i3 = i5;
            }
            iArr[i4] = iArr[i4] + 1;
            i2 >>= 1;
        }
    }

    private static int n(int i2) {
        return o(m(i2));
    }

    private static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    private static int p(int[] iArr) {
        int i2 = -1;
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] q(com.google.zxing.common.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.e(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.i.q(com.google.zxing.common.b, int, int, boolean, int, int):int[]");
    }

    private static int r(int i2) {
        return 2 << i2;
    }

    private static g s(com.google.zxing.common.b bVar, c cVar, l lVar, boolean z, int i2, int i3) {
        g gVar = new g(cVar, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int c2 = (int) lVar.c();
            for (int d2 = (int) lVar.d(); d2 <= cVar.f() && d2 >= cVar.h(); d2 += i5) {
                d k = k(bVar, 0, bVar.l(), z, c2, d2, i2, i3);
                if (k != null) {
                    gVar.f(d2, k);
                    c2 = z ? k.d() : k.b();
                }
            }
            i4++;
        }
        return gVar;
    }

    private static int t(e eVar, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        d b2 = u(eVar, i5) ? eVar.n(i5).b(i3) : null;
        if (b2 != null) {
            return z ? b2.b() : b2.d();
        }
        d c2 = eVar.n(i2).c(i3);
        if (c2 != null) {
            return z ? c2.d() : c2.b();
        }
        if (u(eVar, i5)) {
            c2 = eVar.n(i5).c(i3);
        }
        if (c2 != null) {
            return z ? c2.b() : c2.d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (!u(eVar, i2)) {
                c m = eVar.m();
                return z ? m.g() : m.e();
            }
            for (d dVar : eVar.n(i2).d()) {
                if (dVar != null) {
                    return (z ? dVar.b() : dVar.d()) + (i4 * i6 * (dVar.b() - dVar.d()));
                }
            }
            i6++;
        }
    }

    private static boolean u(e eVar, int i2) {
        return i2 >= 0 && i2 <= eVar.j() + 1;
    }

    private static e v(g gVar, g gVar2) throws NotFoundException {
        a l;
        if ((gVar == null && gVar2 == null) || (l = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(l, c.l(a(gVar), a(gVar2)));
    }

    public static String w(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            formatter.format("Row %2d: ", Integer.valueOf(i2));
            for (int i3 = 0; i3 < bVarArr[i2].length; i3++) {
                b bVar = bVarArr[i2][i3];
                if (bVar.b().length == 0) {
                    formatter.format("        ", null);
                } else {
                    formatter.format("%4d(%2d)", Integer.valueOf(bVar.b()[0]), bVar.a(bVar.b()[0]));
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private static void x(int[] iArr, int i2) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i3 = iArr[0];
        if (i3 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i3 == 0) {
            if (i2 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i2;
        }
    }
}
