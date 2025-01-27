package com.google.zxing.u.c;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a */
    private static final int f8858a = 3;

    /* renamed from: b */
    private static final int f8859b = 3;

    /* renamed from: c */
    private static final int f8860c = 40;

    /* renamed from: d */
    private static final int f8861d = 10;

    private d() {
    }

    static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z) {
        int d2 = z ? bVar.d() : bVar.e();
        int e2 = z ? bVar.e() : bVar.d();
        byte[][] c2 = bVar.c();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte b2 = -1;
            int i4 = 0;
            for (int i5 = 0; i5 < e2; i5++) {
                byte b3 = z ? c2[i3][i5] : c2[i5][i3];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    b2 = b3;
                    i4 = 1;
                }
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
        }
        return i2;
    }

    static int c(b bVar) {
        byte[][] c2 = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2 - 1; i3++) {
            int i4 = 0;
            while (i4 < e2 - 1) {
                byte b2 = c2[i3][i4];
                int i5 = i4 + 1;
                if (b2 == c2[i3][i5]) {
                    int i6 = i3 + 1;
                    if (b2 == c2[i6][i4] && b2 == c2[i6][i5]) {
                        i2++;
                    }
                }
                i4 = i5;
            }
        }
        return i2 * 3;
    }

    static int d(b bVar) {
        byte[][] c2 = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            for (int i4 = 0; i4 < e2; i4++) {
                byte[] bArr = c2[i3];
                int i5 = i4 + 6;
                if (i5 < e2 && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (g(bArr, i4 - 4, i4) || g(bArr, i4 + 7, i4 + 11))) {
                    i2++;
                }
                int i6 = i3 + 6;
                if (i6 < d2 && c2[i3][i4] == 1 && c2[i3 + 1][i4] == 0 && c2[i3 + 2][i4] == 1 && c2[i3 + 3][i4] == 1 && c2[i3 + 4][i4] == 1 && c2[i3 + 5][i4] == 0 && c2[i6][i4] == 1 && (h(c2, i4, i3 - 4, i3) || h(c2, i4, i3 + 7, i3 + 11))) {
                    i2++;
                }
            }
        }
        return i2 * 40;
    }

    static int e(b bVar) {
        byte[][] c2 = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte[] bArr = c2[i3];
            for (int i4 = 0; i4 < e2; i4++) {
                if (bArr[i4] == 1) {
                    i2++;
                }
            }
        }
        int d3 = bVar.d() * bVar.e();
        return ((Math.abs((i2 << 1) - d3) * 10) / d3) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L3e;
                case 1: goto L3f;
                case 2: goto L3b;
                case 3: goto L37;
                case 4: goto L32;
                case 5: goto L2a;
                case 6: goto L21;
                case 7: goto L18;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid mask pattern: "
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L18:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L28
        L21:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L28:
            r1 = r1 & r0
            goto L41
        L2a:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L41
        L32:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L3e
        L37:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L41
        L3b:
            int r1 = r2 % 3
            goto L41
        L3e:
            int r3 = r3 + r2
        L3f:
            r1 = r3 & 1
        L41:
            if (r1 != 0) goto L44
            return r0
        L44:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.u.c.d.f(int, int, int):boolean");
    }

    private static boolean g(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i2, int i3, int i4) {
        int min = Math.min(i4, bArr.length);
        for (int max = Math.max(i3, 0); max < min; max++) {
            if (bArr[max][i2] == 1) {
                return false;
            }
        }
        return true;
    }
}
