package v6;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a */
    public static final int f31240a = 3;

    /* renamed from: b */
    public static final int f31241b = 3;

    /* renamed from: c */
    public static final int f31242c = 40;

    /* renamed from: d */
    public static final int f31243d = 10;

    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    public static int b(b bVar, boolean z10) {
        int d10 = z10 ? bVar.d() : bVar.e();
        int e10 = z10 ? bVar.e() : bVar.d();
        byte[][] c10 = bVar.c();
        int i10 = 0;
        for (int i11 = 0; i11 < d10; i11++) {
            byte b10 = -1;
            int i12 = 0;
            for (int i13 = 0; i13 < e10; i13++) {
                byte b11 = z10 ? c10[i11][i13] : c10[i13][i11];
                if (b11 == b10) {
                    i12++;
                } else {
                    if (i12 >= 5) {
                        i10 += i12 - 2;
                    }
                    b10 = b11;
                    i12 = 1;
                }
            }
            if (i12 >= 5) {
                i10 += i12 - 2;
            }
        }
        return i10;
    }

    public static int c(b bVar) {
        byte[][] c10 = bVar.c();
        int e10 = bVar.e();
        int d10 = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10 - 1; i11++) {
            int i12 = 0;
            while (i12 < e10 - 1) {
                byte[] bArr = c10[i11];
                byte b10 = bArr[i12];
                int i13 = i12 + 1;
                if (b10 == bArr[i13]) {
                    byte[] bArr2 = c10[i11 + 1];
                    if (b10 == bArr2[i12] && b10 == bArr2[i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    public static int d(b bVar) {
        byte[][] c10 = bVar.c();
        int e10 = bVar.e();
        int d10 = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10; i11++) {
            for (int i12 = 0; i12 < e10; i12++) {
                byte[] bArr = c10[i11];
                int i13 = i12 + 6;
                if (i13 < e10 && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (g(bArr, i12 - 4, i12) || g(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < d10 && c10[i11][i12] == 1 && c10[i11 + 1][i12] == 0 && c10[i11 + 2][i12] == 1 && c10[i11 + 3][i12] == 1 && c10[i11 + 4][i12] == 1 && c10[i11 + 5][i12] == 0 && c10[i14][i12] == 1 && (h(c10, i12, i11 - 4, i11) || h(c10, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    public static int e(b bVar) {
        byte[][] c10 = bVar.c();
        int e10 = bVar.e();
        int d10 = bVar.d();
        int i10 = 0;
        for (int i11 = 0; i11 < d10; i11++) {
            byte[] bArr = c10[i11];
            for (int i12 = 0; i12 < e10; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int d11 = bVar.d() * bVar.e();
        return ((Math.abs((i10 << 1) - d11) * 10) / d11) * 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0042 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L36;
                case 1: goto L37;
                case 2: goto L3e;
                case 3: goto L3a;
                case 4: goto L32;
                case 5: goto L2a;
                case 6: goto L22;
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
        L20:
            r1 = r1 & r0
            goto L40
        L22:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L20
        L2a:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L40
        L32:
            int r3 = r3 / 2
            int r2 = r2 / 3
        L36:
            int r3 = r3 + r2
        L37:
            r1 = r3 & 1
            goto L40
        L3a:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L40
        L3e:
            int r1 = r2 % 3
        L40:
            if (r1 != 0) goto L43
            return r0
        L43:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.d.f(int, int, int):boolean");
    }

    public static boolean g(byte[] bArr, int i10, int i11) {
        int min = Math.min(i11, bArr.length);
        for (int max = Math.max(i10, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(byte[][] bArr, int i10, int i11, int i12) {
        int min = Math.min(i12, bArr.length);
        for (int max = Math.max(i11, 0); max < min; max++) {
            if (bArr[max][i10] == 1) {
                return false;
            }
        }
        return true;
    }
}
