package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import n6.c;

/* loaded from: classes2.dex */
public final class DecodedBitStreamParser {

    /* renamed from: a */
    public static final int f10588a = 900;

    /* renamed from: b */
    public static final int f10589b = 901;

    /* renamed from: c */
    public static final int f10590c = 902;

    /* renamed from: d */
    public static final int f10591d = 924;

    /* renamed from: e */
    public static final int f10592e = 925;

    /* renamed from: f */
    public static final int f10593f = 926;

    /* renamed from: g */
    public static final int f10594g = 927;

    /* renamed from: h */
    public static final int f10595h = 928;

    /* renamed from: i */
    public static final int f10596i = 923;

    /* renamed from: j */
    public static final int f10597j = 922;

    /* renamed from: k */
    public static final int f10598k = 913;

    /* renamed from: l */
    public static final int f10599l = 15;

    /* renamed from: m */
    public static final int f10600m = 25;

    /* renamed from: n */
    public static final int f10601n = 27;

    /* renamed from: o */
    public static final int f10602o = 27;

    /* renamed from: p */
    public static final int f10603p = 28;

    /* renamed from: q */
    public static final int f10604q = 28;

    /* renamed from: r */
    public static final int f10605r = 29;

    /* renamed from: s */
    public static final int f10606s = 29;

    /* renamed from: t */
    public static final char[] f10607t = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: u */
    public static final char[] f10608u = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: v */
    public static final Charset f10609v = Charset.forName("ISO-8859-1");

    /* renamed from: w */
    public static final BigInteger[] f10610w;

    /* renamed from: x */
    public static final int f10611x = 2;

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10612a;

        static {
            int[] iArr = new int[Mode.values().length];
            f10612a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10612a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10612a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10612a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10612a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10612a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f10610w = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f10610w;
            if (i10 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
            i10++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r7 >= 6) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r1.write((byte) (r18 >> ((5 - r7) * 8)));
        r7 = r7 + 1;
        r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.f10597j;
        r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.f10596i;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r20, int[] r21, java.nio.charset.Charset r22, int r23, java.lang.StringBuilder r24) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static z5.d b(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.f10609v
            r2 = r6[r2]
            n6.c r3 = new n6.c
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
            z5.d r6 = new z5.d
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.o(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.b(int[], java.lang.String):z5.d");
    }

    public static String c(int[] iArr, int i10) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(f10610w[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int d(int[] iArr, int i10, c cVar) throws FormatException {
        if (i10 + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i11 = 0;
        while (i11 < 2) {
            iArr2[i11] = iArr[i10];
            i11++;
            i10++;
        }
        cVar.h(Integer.parseInt(c(iArr2, 2)));
        StringBuilder sb2 = new StringBuilder();
        int g10 = g(iArr, i10, sb2);
        cVar.e(sb2.toString());
        int i12 = iArr[g10];
        if (i12 != 923) {
            if (i12 != 922) {
                return g10;
            }
            cVar.f(true);
            return g10 + 1;
        }
        int i13 = g10 + 1;
        int[] iArr3 = new int[iArr[0] - i13];
        boolean z10 = false;
        int i14 = 0;
        while (i13 < iArr[0] && !z10) {
            int i15 = i13 + 1;
            int i16 = iArr[i13];
            if (i16 < 900) {
                iArr3[i14] = i16;
                i14++;
                i13 = i15;
            } else {
                if (i16 != 922) {
                    throw FormatException.getFormatInstance();
                }
                cVar.f(true);
                i13 += 2;
                z10 = true;
            }
        }
        cVar.g(Arrays.copyOf(iArr3, i14));
        return i13;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(int[] iArr, int[] iArr2, int i10, StringBuilder sb2) {
        Mode mode;
        int i11;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12];
            int i14 = a.f10612a[mode2.ordinal()];
            char c10 = b5.a.O;
            switch (i14) {
                case 1:
                    if (i13 < 26) {
                        i11 = i13 + 65;
                        c10 = (char) i11;
                        break;
                    } else if (i13 != 26) {
                        if (i13 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i13 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i13 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c10 = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i13 == 913) {
                            sb2.append((char) iArr2[i12]);
                        } else if (i13 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i13 < 26) {
                        i11 = i13 + 97;
                        c10 = (char) i11;
                        break;
                    } else if (i13 != 26) {
                        if (i13 != 27) {
                            if (i13 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i13 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i13 == 913) {
                                sb2.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c10 = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c10 = 0;
                        Mode mode42 = mode;
                        mode3 = mode2;
                        mode2 = mode42;
                        break;
                    }
                    break;
                case 3:
                    if (i13 < 25) {
                        c10 = f10608u[i13];
                        break;
                    } else {
                        if (i13 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i13 != 26) {
                            if (i13 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i13 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i13 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c10 = 0;
                                Mode mode422 = mode;
                                mode3 = mode2;
                                mode2 = mode422;
                                break;
                            } else if (i13 == 913) {
                                sb2.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c10 = 0;
                        break;
                    }
                case 4:
                    if (i13 < 29) {
                        c10 = f10607t[i13];
                        break;
                    } else {
                        if (i13 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i13 == 913) {
                            sb2.append((char) iArr2[i12]);
                        } else if (i13 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                case 5:
                    if (i13 < 26) {
                        c10 = (char) (i13 + 65);
                    } else if (i13 != 26) {
                        if (i13 == 900) {
                            mode2 = Mode.ALPHA;
                            c10 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c10 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i13 < 29) {
                        c10 = f10607t[i13];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i13 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i13 == 913) {
                                sb2.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            mode2 = mode3;
                        }
                        c10 = 0;
                        break;
                    }
                default:
                    c10 = 0;
                    break;
            }
            if (c10 != 0) {
                sb2.append(c10);
            }
        }
    }

    public static int f(int[] iArr, int i10, StringBuilder sb2) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z10 = false;
        loop0: while (true) {
            int i11 = 0;
            while (true) {
                int i12 = iArr[0];
                if (i10 >= i12 || z10) {
                    break loop0;
                }
                int i13 = i10 + 1;
                int i14 = iArr[i10];
                if (i13 == i12) {
                    z10 = true;
                }
                if (i14 < 900) {
                    iArr2[i11] = i14;
                    i11++;
                } else if (i14 == 900 || i14 == 901 || i14 == 924 || i14 == 928 || i14 == 923 || i14 == 922) {
                    z10 = true;
                    if (i11 % 15 != 0 || i14 == 902 || z10) {
                    }
                }
                i10 = i13;
                if (i11 % 15 != 0) {
                }
            }
            sb2.append(c(iArr2, i11));
        }
        return i10;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0036. Please report as an issue. */
    public static int g(int[] iArr, int i10, StringBuilder sb2) {
        int i11 = iArr[0];
        int[] iArr2 = new int[(i11 - i10) << 1];
        int[] iArr3 = new int[(i11 - i10) << 1];
        boolean z10 = false;
        int i12 = 0;
        while (i10 < iArr[0] && !z10) {
            int i13 = i10 + 1;
            int i14 = iArr[i10];
            if (i14 < 900) {
                iArr2[i12] = i14 / 30;
                iArr2[i12 + 1] = i14 % 30;
                i12 += 2;
            } else if (i14 != 913) {
                if (i14 != 928) {
                    switch (i14) {
                        case 900:
                            iArr2[i12] = 900;
                            i12++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i14) {
                            }
                    }
                }
                z10 = true;
            } else {
                iArr2[i12] = 913;
                i10 += 2;
                iArr3[i12] = iArr[i13];
                i12++;
            }
            i10 = i13;
        }
        e(iArr2, iArr3, i12, sb2);
        return i10;
    }
}
