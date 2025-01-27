package o6;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;
import t5.l;

/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a */
    public static final int f29096a = 2;

    /* renamed from: b */
    public static final int f29097b = 3;

    /* renamed from: c */
    public static final int f29098c = 512;

    /* renamed from: d */
    public static final p6.a f29099d = new p6.a();

    public static c a(g gVar) throws NotFoundException {
        int[] j10;
        if (gVar == null || (j10 = gVar.j()) == null) {
            return null;
        }
        int p10 = p(j10);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : j10) {
            i11 += p10 - i12;
            if (i12 > 0) {
                break;
            }
        }
        d[] d10 = gVar.d();
        for (int i13 = 0; i11 > 0 && d10[i13] == null; i13++) {
            i11--;
        }
        for (int length = j10.length - 1; length >= 0; length--) {
            int i14 = j10[length];
            i10 += p10 - i14;
            if (i14 > 0) {
                break;
            }
        }
        for (int length2 = d10.length - 1; i10 > 0 && d10[length2] == null; length2--) {
            i10--;
        }
        return gVar.a().a(i11, i10, gVar.k());
    }

    public static void b(e eVar, b[][] bVarArr) throws NotFoundException {
        int[] b10 = bVarArr[0][1].b();
        int j10 = (eVar.j() * eVar.l()) - r(eVar.k());
        if (b10.length != 0) {
            if (b10[0] != j10) {
                bVarArr[0][1].c(j10);
            }
        } else {
            if (j10 <= 0 || j10 > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            bVarArr[0][1].c(j10);
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
    public static int c(z5.b r5, int r6, int r7, boolean r8, int r9, int r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: o6.i.c(z5.b, int, int, boolean, int, int):int");
    }

    public static boolean d(int i10, int i11, int i12) {
        return i11 + (-2) <= i10 && i10 <= i12 + 2;
    }

    public static int e(int[] iArr, int[] iArr2, int i10) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f29099d.a(iArr, i10, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    public static b[][] f(e eVar) {
        int c10;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, eVar.l(), eVar.j() + 2);
        for (b[] bVarArr2 : bVarArr) {
            int i10 = 0;
            while (true) {
                if (i10 < bVarArr2.length) {
                    bVarArr2[i10] = new b();
                    i10++;
                }
            }
        }
        int i11 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (c10 = dVar.c()) >= 0 && c10 < bVarArr.length) {
                        bVarArr[c10][i11].c(dVar.e());
                    }
                }
            }
            i11++;
        }
        return bVarArr;
    }

    public static z5.d g(e eVar) throws FormatException, ChecksumException, NotFoundException {
        b[][] f10 = f(eVar);
        b(eVar, f10);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < eVar.l(); i10++) {
            int i11 = 0;
            while (i11 < eVar.j()) {
                int i12 = i11 + 1;
                int[] b10 = f10[i10][i12].b();
                int j10 = (eVar.j() * i10) + i11;
                if (b10.length == 0) {
                    arrayList.add(Integer.valueOf(j10));
                } else if (b10.length == 1) {
                    iArr[j10] = b10[0];
                } else {
                    arrayList3.add(Integer.valueOf(j10));
                    arrayList2.add(b10);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return h(eVar.k(), iArr, n6.a.c(arrayList), n6.a.c(arrayList3), iArr2);
    }

    public static z5.d h(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            int i12 = i11 - 1;
            if (i11 <= 0) {
                throw ChecksumException.getChecksumInstance();
            }
            for (int i13 = 0; i13 < length; i13++) {
                iArr[iArr3[i13]] = iArr4[i13][iArr5[i13]];
            }
            try {
                return j(iArr, i10, iArr2);
            } catch (ChecksumException unused) {
                if (length == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int i14 = 0;
                while (true) {
                    if (i14 >= length) {
                        break;
                    }
                    int i15 = iArr5[i14];
                    if (i15 < iArr4[i14].length - 1) {
                        iArr5[i14] = i15 + 1;
                        break;
                    }
                    iArr5[i14] = 0;
                    if (i14 == length - 1) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    i14++;
                }
                i11 = i12;
            }
        }
    }

    public static z5.d i(z5.b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i10, int i11) throws NotFoundException, FormatException, ChecksumException {
        int i12;
        int i13;
        int i14;
        g gVar = null;
        g gVar2 = null;
        e eVar = null;
        c cVar = new c(bVar, lVar, lVar2, lVar3, lVar4);
        for (int i15 = 0; i15 < 2; i15++) {
            if (lVar != null) {
                gVar = s(bVar, cVar, lVar, true, i10, i11);
            }
            if (lVar3 != null) {
                gVar2 = s(bVar, cVar, lVar3, false, i10, i11);
            }
            eVar = v(gVar, gVar2);
            if (eVar == null) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i15 != 0 || eVar.m() == null || (eVar.m().h() >= cVar.h() && eVar.m().f() <= cVar.f())) {
                eVar.p(cVar);
                break;
            }
            cVar = eVar.m();
        }
        int j10 = eVar.j() + 1;
        eVar.q(0, gVar);
        eVar.q(j10, gVar2);
        boolean z10 = gVar != null;
        int i16 = i10;
        int i17 = i11;
        for (int i18 = 1; i18 <= j10; i18++) {
            int i19 = z10 ? i18 : j10 - i18;
            if (eVar.n(i19) == null) {
                f gVar3 = (i19 == 0 || i19 == j10) ? new g(cVar, i19 == 0) : new f(cVar);
                eVar.q(i19, gVar3);
                int i20 = -1;
                int h10 = cVar.h();
                int i21 = -1;
                while (h10 <= cVar.f()) {
                    int t10 = t(eVar, i19, h10, z10);
                    if (t10 >= 0 && t10 <= cVar.e()) {
                        i14 = t10;
                    } else if (i21 != i20) {
                        i14 = i21;
                    } else {
                        i12 = i21;
                        i13 = h10;
                        i21 = i12;
                        h10 = i13 + 1;
                        i20 = -1;
                    }
                    i12 = i21;
                    int i22 = h10;
                    d k10 = k(bVar, cVar.g(), cVar.e(), z10, i14, i22, i16, i17);
                    i13 = i22;
                    if (k10 != null) {
                        gVar3.f(i13, k10);
                        i16 = Math.min(i16, k10.f());
                        i17 = Math.max(i17, k10.f());
                        i21 = i14;
                        h10 = i13 + 1;
                        i20 = -1;
                    }
                    i21 = i12;
                    h10 = i13 + 1;
                    i20 = -1;
                }
            }
        }
        return g(eVar);
    }

    public static z5.d j(int[] iArr, int i10, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length == 0) {
            throw FormatException.getFormatInstance();
        }
        int i11 = 1 << (i10 + 1);
        int e10 = e(iArr, iArr2, i11);
        x(iArr, i11);
        z5.d b10 = DecodedBitStreamParser.b(iArr, String.valueOf(i10));
        b10.m(Integer.valueOf(e10));
        b10.l(Integer.valueOf(iArr2.length));
        return b10;
    }

    public static d k(z5.b bVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int d10;
        int b10;
        int c10 = c(bVar, i10, i11, z10, i12, i13);
        int[] q10 = q(bVar, i10, i11, z10, c10, i13);
        if (q10 == null) {
            return null;
        }
        int d11 = a6.a.d(q10);
        if (z10) {
            i16 = c10 + d11;
        } else {
            for (int i17 = 0; i17 < q10.length / 2; i17++) {
                int i18 = q10[i17];
                q10[i17] = q10[(q10.length - 1) - i17];
                q10[(q10.length - 1) - i17] = i18;
            }
            c10 -= d11;
            i16 = c10;
        }
        if (d(d11, i14, i15) && (b10 = n6.a.b((d10 = h.d(q10)))) != -1) {
            return new d(c10, i16, n(d10), b10);
        }
        return null;
    }

    public static a l(g gVar, g gVar2) {
        a i10;
        a i11;
        if (gVar == null || (i10 = gVar.i()) == null) {
            if (gVar2 == null) {
                return null;
            }
            return gVar2.i();
        }
        if (gVar2 == null || (i11 = gVar2.i()) == null || i10.a() == i11.a() || i10.b() == i11.b() || i10.c() == i11.c()) {
            return i10;
        }
        return null;
    }

    public static int[] m(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 < 0) {
                    return iArr;
                }
                i11 = i13;
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    public static int n(int i10) {
        return o(m(i10));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int i10 = -1;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] q(z5.b r7, int r8, int r9, boolean r10, int r11, int r12) {
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
        throw new UnsupportedOperationException("Method not decompiled: o6.i.q(z5.b, int, int, boolean, int, int):int[]");
    }

    public static int r(int i10) {
        return 2 << i10;
    }

    public static g s(z5.b bVar, c cVar, l lVar, boolean z10, int i10, int i11) {
        g gVar = new g(cVar, z10);
        int i12 = 0;
        while (i12 < 2) {
            int i13 = i12 == 0 ? 1 : -1;
            int c10 = (int) lVar.c();
            for (int d10 = (int) lVar.d(); d10 <= cVar.f() && d10 >= cVar.h(); d10 += i13) {
                d k10 = k(bVar, 0, bVar.l(), z10, c10, d10, i10, i11);
                if (k10 != null) {
                    gVar.f(d10, k10);
                    c10 = z10 ? k10.d() : k10.b();
                }
            }
            i12++;
        }
        return gVar;
    }

    public static int t(e eVar, int i10, int i11, boolean z10) {
        int i12 = z10 ? 1 : -1;
        int i13 = i10 - i12;
        d b10 = u(eVar, i13) ? eVar.n(i13).b(i11) : null;
        if (b10 != null) {
            return z10 ? b10.b() : b10.d();
        }
        d c10 = eVar.n(i10).c(i11);
        if (c10 != null) {
            return z10 ? c10.d() : c10.b();
        }
        if (u(eVar, i13)) {
            c10 = eVar.n(i13).c(i11);
        }
        if (c10 != null) {
            return z10 ? c10.b() : c10.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (!u(eVar, i10)) {
                c m10 = eVar.m();
                return z10 ? m10.g() : m10.e();
            }
            for (d dVar : eVar.n(i10).d()) {
                if (dVar != null) {
                    return (z10 ? dVar.b() : dVar.d()) + (i12 * i14 * (dVar.b() - dVar.d()));
                }
            }
            i14++;
        }
    }

    public static boolean u(e eVar, int i10) {
        return i10 >= 0 && i10 <= eVar.j() + 1;
    }

    public static e v(g gVar, g gVar2) throws NotFoundException {
        a l10;
        if ((gVar == null && gVar2 == null) || (l10 = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(l10, c.l(a(gVar), a(gVar2)));
    }

    public static String w(b[][] bVarArr) {
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            formatter.format("Row %2d: ", Integer.valueOf(i10));
            int i11 = 0;
            while (true) {
                b[] bVarArr2 = bVarArr[i10];
                if (i11 < bVarArr2.length) {
                    b bVar = bVarArr2[i11];
                    if (bVar.b().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", Integer.valueOf(bVar.b()[0]), bVar.a(bVar.b()[0]));
                    }
                    i11++;
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    public static void x(int[] iArr, int i10) throws FormatException {
        if (iArr.length < 4) {
            throw FormatException.getFormatInstance();
        }
        int i11 = iArr[0];
        if (i11 > iArr.length) {
            throw FormatException.getFormatInstance();
        }
        if (i11 == 0) {
            if (i10 >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i10;
        }
    }
}
