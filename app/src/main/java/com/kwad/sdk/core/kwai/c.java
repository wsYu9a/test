package com.kwad.sdk.core.kwai;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static class a {
        private static final int[] afB;
        private final boolean afD;
        private final boolean afE = false;
        static final a afz = new a(false, false);
        static final a afA = new a(true, false);
        private static final int[] afC = new int[256];

        static {
            int[] iArr = new int[256];
            afB = iArr;
            Arrays.fill(iArr, -1);
            for (int i2 = 0; i2 < b.afH.length; i2++) {
                afB[b.afH[i2]] = i2;
            }
            afB[61] = -2;
            Arrays.fill(afC, -1);
            for (int i3 = 0; i3 < b.afI.length; i3++) {
                afC[b.afI[i3]] = i3;
            }
            afC[61] = -2;
        }

        private a(boolean z, boolean z2) {
            this.afD = z;
        }

        private int a(byte[] bArr, int i2, int i3) {
            int i4;
            int[] iArr = this.afD ? afC : afB;
            int i5 = i3 + 0;
            int i6 = 0;
            if (i5 == 0) {
                return 0;
            }
            if (i5 < 2) {
                if (this.afE && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.afE) {
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int i8 = i2 + 1;
                    int i9 = bArr[i2] & 255;
                    if (i9 == 61) {
                        i5 -= (i3 - i8) + 1;
                        break;
                    }
                    if (iArr[i9] == -1) {
                        i7++;
                    }
                    i2 = i8;
                }
                i5 -= i7;
            } else if (bArr[i3 - 1] == 61) {
                i6 = bArr[i3 - 2] == 61 ? 2 : 1;
            }
            if (i6 == 0 && (i4 = i5 & 3) != 0) {
                i6 = 4 - i4;
            }
            return (((i5 + 3) / 4) * 3) - i6;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:
        
            if (r11[r8] == 61) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
        
            if (r4 != 18) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
        
            if (r4 != 6) goto L97;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
        
            r14[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
        
            if (r12 >= r13) goto L122;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a0, code lost:
        
            if (r10.afE == false) goto L120;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a2, code lost:
        
            r14 = r12 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
        
            if (r0[r11[r12]] >= 0) goto L121;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ac, code lost:
        
            r12 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00c0, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c1, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0087, code lost:
        
            if (r4 != 0) goto L99;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0089, code lost:
        
            r1 = r5 + 1;
            r14[r5] = (byte) (r3 >> 16);
            r5 = r1 + 1;
            r14[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        
            if (r4 == 12) goto L111;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ca, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r11, int r12, int r13, byte[] r14) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.kwai.c.a.a(byte[], int, int, byte[]):int");
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        public final byte[] decode(byte[] bArr) {
            int a2 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a2];
            int a3 = a(bArr, 0, bArr.length, bArr2);
            return a3 != a2 ? Arrays.copyOf(bArr2, a3) : bArr2;
        }
    }

    public static class b {
        static final b afF = new b(false, null, -1, true);
        static final b afG = new b(true, null, -1, false);
        private static final char[] afH = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] afI = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean afD;
        private final byte[] afJ = null;
        private final int afK = -1;
        private final boolean afL;

        private b(boolean z, byte[] bArr, int i2, boolean z2) {
            this.afD = z;
            this.afL = z2;
        }

        private int b(byte[] bArr, int i2, int i3, byte[] bArr2) {
            char[] cArr = this.afD ? afI : afH;
            int i4 = ((i3 + 0) / 3) * 3;
            int i5 = i4 + 0;
            int i6 = this.afK;
            if (i6 > 0 && i4 > (i6 / 4) * 3) {
                i4 = (i6 / 4) * 3;
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < i5) {
                int min = Math.min(i7 + i4, i5);
                int i9 = i7;
                int i10 = i8;
                while (i9 < min) {
                    int i11 = i9 + 1;
                    int i12 = i11 + 1;
                    int i13 = ((bArr[i9] & 255) << 16) | ((bArr[i11] & 255) << 8);
                    int i14 = i12 + 1;
                    int i15 = i13 | (bArr[i12] & 255);
                    int i16 = i10 + 1;
                    bArr2[i10] = (byte) cArr[(i15 >>> 18) & 63];
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) cArr[(i15 >>> 12) & 63];
                    int i18 = i17 + 1;
                    bArr2[i17] = (byte) cArr[(i15 >>> 6) & 63];
                    i10 = i18 + 1;
                    bArr2[i18] = (byte) cArr[i15 & 63];
                    i9 = i14;
                }
                int i19 = ((min - i7) / 3) * 4;
                i8 += i19;
                if (i19 == this.afK && min < i3) {
                    byte[] bArr3 = this.afJ;
                    int length = bArr3.length;
                    int i20 = 0;
                    while (i20 < length) {
                        bArr2[i8] = bArr3[i20];
                        i20++;
                        i8++;
                    }
                }
                i7 = min;
            }
            if (i7 >= i3) {
                return i8;
            }
            int i21 = i7 + 1;
            int i22 = bArr[i7] & 255;
            int i23 = i8 + 1;
            bArr2[i8] = (byte) cArr[i22 >> 2];
            if (i21 == i3) {
                int i24 = i23 + 1;
                bArr2[i23] = (byte) cArr[(i22 << 4) & 63];
                if (!this.afL) {
                    return i24;
                }
                int i25 = i24 + 1;
                bArr2[i24] = 61;
                int i26 = i25 + 1;
                bArr2[i25] = 61;
                return i26;
            }
            int i27 = bArr[i21] & 255;
            int i28 = i23 + 1;
            bArr2[i23] = (byte) cArr[((i22 << 4) & 63) | (i27 >> 4)];
            int i29 = i28 + 1;
            bArr2[i28] = (byte) cArr[(i27 << 2) & 63];
            if (!this.afL) {
                return i29;
            }
            int i30 = i29 + 1;
            bArr2[i29] = 61;
            return i30;
        }

        private final int ba(int i2) {
            int i3;
            if (this.afL) {
                i3 = ((i2 + 2) / 3) * 4;
            } else {
                int i4 = i2 % 3;
                i3 = ((i2 / 3) * 4) + (i4 == 0 ? 0 : i4 + 1);
            }
            int i5 = this.afK;
            return i5 > 0 ? i3 + (((i3 - 1) / i5) * this.afJ.length) : i3;
        }

        public final byte[] encode(byte[] bArr) {
            int ba = ba(bArr.length);
            byte[] bArr2 = new byte[ba];
            int b2 = b(bArr, 0, bArr.length, bArr2);
            return b2 != ba ? Arrays.copyOf(bArr2, b2) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static String bW(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(vH().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String bX(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(vJ().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static boolean bY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    public static b vH() {
        return b.afF;
    }

    public static b vI() {
        return b.afG;
    }

    public static a vJ() {
        return a.afz;
    }

    public static a vK() {
        return a.afA;
    }
}
