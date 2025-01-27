package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes.dex */
final class DecodedBitStreamParser {

    /* renamed from: a */
    private static final int f8658a = 900;

    /* renamed from: b */
    private static final int f8659b = 901;

    /* renamed from: c */
    private static final int f8660c = 902;

    /* renamed from: d */
    private static final int f8661d = 924;

    /* renamed from: e */
    private static final int f8662e = 925;

    /* renamed from: f */
    private static final int f8663f = 926;

    /* renamed from: g */
    private static final int f8664g = 927;

    /* renamed from: h */
    private static final int f8665h = 928;

    /* renamed from: i */
    private static final int f8666i = 923;

    /* renamed from: j */
    private static final int f8667j = 922;
    private static final int k = 913;
    private static final int l = 15;
    private static final int m = 25;
    private static final int n = 27;
    private static final int o = 27;
    private static final int p = 28;
    private static final int q = 28;
    private static final int r = 29;
    private static final int s = 29;
    private static final char[] t = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] u = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset v = Charset.forName("ISO-8859-1");
    private static final BigInteger[] w;
    private static final int x = 2;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8668a;

        static {
            int[] iArr = new int[Mode.values().length];
            f8668a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8668a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8668a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8668a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8668a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8668a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        w = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = w;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
            i2++;
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int a(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        int i5;
        int i6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = f8667j;
        int i8 = f8666i;
        int i9 = 928;
        int i10 = f8660c;
        long j2 = 900;
        if (i2 == f8659b) {
            int[] iArr2 = new int[6];
            i4 = i3 + 1;
            int i11 = iArr[i3];
            boolean z = false;
            loop0: while (true) {
                i5 = 0;
                long j3 = 0;
                while (i4 < iArr[0] && !z) {
                    int i12 = i5 + 1;
                    iArr2[i5] = i11;
                    j3 = (j3 * j2) + i11;
                    int i13 = i4 + 1;
                    i11 = iArr[i4];
                    if (i11 == f8658a || i11 == f8659b || i11 == f8660c || i11 == f8661d || i11 == 928 || i11 == i8 || i11 == i7) {
                        i4 = i13 - 1;
                        i5 = i12;
                        i7 = f8667j;
                        i8 = f8666i;
                        j2 = 900;
                        z = true;
                    } else if (i12 % 5 != 0 || i12 <= 0) {
                        i4 = i13;
                        i5 = i12;
                        i7 = f8667j;
                        i8 = f8666i;
                        j2 = 900;
                    } else {
                        int i14 = 0;
                        while (i14 < 6) {
                            byteArrayOutputStream.write((byte) (j3 >> ((5 - i14) * 8)));
                            i14++;
                            i7 = f8667j;
                            i8 = f8666i;
                        }
                        i4 = i13;
                        j2 = 900;
                    }
                }
            }
            if (i4 != iArr[0] || i11 >= f8658a) {
                i6 = i5;
            } else {
                i6 = i5 + 1;
                iArr2[i5] = i11;
            }
            for (int i15 = 0; i15 < i6; i15++) {
                byteArrayOutputStream.write((byte) iArr2[i15]);
            }
        } else if (i2 == f8661d) {
            int i16 = i3;
            boolean z2 = false;
            int i17 = 0;
            long j4 = 0;
            while (i16 < iArr[0] && !z2) {
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                if (i19 < f8658a) {
                    i17++;
                    j4 = (j4 * 900) + i19;
                    i16 = i18;
                } else {
                    if (i19 != f8658a && i19 != f8659b && i19 != i10 && i19 != f8661d && i19 != i9) {
                        if (i19 != f8666i && i19 != f8667j) {
                            i16 = i18;
                        }
                    }
                    i16 = i18 - 1;
                    z2 = true;
                }
                if (i17 % 5 == 0 && i17 > 0) {
                    for (int i20 = 0; i20 < 6; i20++) {
                        byteArrayOutputStream.write((byte) (j4 >> ((5 - i20) * 8)));
                    }
                    i17 = 0;
                    j4 = 0;
                }
                i9 = 928;
                i10 = f8660c;
            }
            i4 = i16;
        } else {
            i4 = i3;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.zxing.common.d b(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.v
            r2 = r6[r2]
            com.google.zxing.t.c r3 = new com.google.zxing.t.c
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = g(r6, r4, r0)
            goto L60
        L28:
            int r2 = d(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = f(r6, r4, r0)
            goto L60
        L4e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = g(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            com.google.zxing.common.d r6 = new com.google.zxing.common.d
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.o(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            goto L87
        L86:
            throw r6
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.b(int[], java.lang.String):com.google.zxing.common.d");
    }

    private static String c(int[] iArr, int i2) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(w[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int d(int[] iArr, int i2, com.google.zxing.t.c cVar) throws FormatException {
        if (i2 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i3 = 0;
        while (i3 < 2) {
            iArr2[i3] = iArr[i2];
            i3++;
            i2++;
        }
        cVar.h(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int g2 = g(iArr, i2, sb);
        cVar.e(sb.toString());
        if (iArr[g2] != f8666i) {
            if (iArr[g2] != f8667j) {
                return g2;
            }
            cVar.f(true);
            return g2 + 1;
        }
        int i4 = g2 + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < f8658a) {
                iArr3[i5] = i7;
                i4 = i6;
                i5++;
            } else {
                if (i7 != f8667j) {
                    throw FormatException.getFormatInstance();
                }
                cVar.f(true);
                i4 = i6 + 1;
                z = true;
            }
        }
        cVar.g(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        Mode mode;
        int i3;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            char c2 = ' ';
            switch (a.f8668a[mode2.ordinal()]) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else if (i5 != 26) {
                        if (i5 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i5 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i5 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c2 = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i5 == k) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == f8658a) {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else if (i5 != 26) {
                        if (i5 != 27) {
                            if (i5 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i5 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i5 == k) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == f8658a) {
                                mode2 = Mode.ALPHA;
                            }
                            c2 = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c2 = 0;
                        Mode mode42 = mode;
                        mode3 = mode2;
                        mode2 = mode42;
                        break;
                    }
                    break;
                case 3:
                    if (i5 < 25) {
                        c2 = u[i5];
                        break;
                    } else {
                        if (i5 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i5 != 26) {
                            if (i5 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i5 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i5 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c2 = 0;
                                Mode mode422 = mode;
                                mode3 = mode2;
                                mode2 = mode422;
                                break;
                            } else if (i5 == k) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == f8658a) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i5 < 29) {
                        c2 = t[i5];
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 == k) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == f8658a) {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c2 = (char) (i5 + 65);
                    } else if (i5 != 26) {
                        if (i5 == f8658a) {
                            mode2 = Mode.ALPHA;
                            c2 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c2 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i5 < 29) {
                        c2 = t[i5];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i5 == k) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == f8658a) {
                                mode2 = Mode.ALPHA;
                            }
                            mode2 = mode3;
                        }
                        c2 = 0;
                        break;
                    }
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int f(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < f8658a) {
                iArr2[i3] = i5;
                i3++;
            } else if (i5 == f8658a || i5 == f8659b || i5 == f8661d || i5 == 928 || i5 == f8666i || i5 == f8667j) {
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == f8660c || z) && i3 > 0) {
                sb.append(c(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0037. Please report as an issue. */
    private static int g(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) << 1];
        int[] iArr3 = new int[(iArr[0] - i2) << 1];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < f8658a) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != k) {
                if (i5 != 928) {
                    switch (i5) {
                        case f8658a /* 900 */:
                            iArr2[i3] = f8658a;
                            i3++;
                            break;
                        case f8659b /* 901 */:
                        case f8660c /* 902 */:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = k;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i2;
    }
}
