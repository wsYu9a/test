package com.kwad.sdk.core.a;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: classes3.dex */
public final class c {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static class b {
        static final b ayU = new b(false, null, -1, true);
        static final b ayV = new b(true, null, -1, false);
        private static final char[] ayW = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        private static final char[] ayX = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '_'};
        private final boolean ayS;
        private final byte[] ayY = null;
        private final int ayZ = -1;
        private final boolean aza;

        private b(boolean z10, byte[] bArr, int i10, boolean z11) {
            this.ayS = z10;
            this.aza = z11;
        }

        private int b(byte[] bArr, int i10, int i11, byte[] bArr2) {
            char[] cArr = this.ayS ? ayX : ayW;
            int i12 = (i11 / 3) * 3;
            int i13 = this.ayZ;
            int i14 = (i13 <= 0 || i12 <= (i13 / 4) * 3) ? i12 : (i13 / 4) * 3;
            int i15 = 0;
            int i16 = 0;
            while (i15 < i12) {
                int min = Math.min(i15 + i14, i12);
                int i17 = i15;
                int i18 = i16;
                while (i17 < min) {
                    int i19 = i17 + 2;
                    int i20 = ((bArr[i17 + 1] & 255) << 8) | ((bArr[i17] & 255) << 16);
                    i17 += 3;
                    int i21 = i20 | (bArr[i19] & 255);
                    bArr2[i18] = (byte) cArr[(i21 >>> 18) & 63];
                    bArr2[i18 + 1] = (byte) cArr[(i21 >>> 12) & 63];
                    int i22 = i18 + 3;
                    bArr2[i18 + 2] = (byte) cArr[(i21 >>> 6) & 63];
                    i18 += 4;
                    bArr2[i22] = (byte) cArr[i21 & 63];
                }
                int i23 = ((min - i15) / 3) * 4;
                i16 += i23;
                if (i23 == this.ayZ && min < i11) {
                    byte[] bArr3 = this.ayY;
                    int length = bArr3.length;
                    int i24 = 0;
                    while (i24 < length) {
                        bArr2[i16] = bArr3[i24];
                        i24++;
                        i16++;
                    }
                }
                i15 = min;
            }
            if (i15 >= i11) {
                return i16;
            }
            int i25 = i15 + 1;
            int i26 = bArr[i15] & 255;
            int i27 = i16 + 1;
            bArr2[i16] = (byte) cArr[i26 >> 2];
            if (i25 == i11) {
                int i28 = i16 + 2;
                bArr2[i27] = (byte) cArr[(i26 << 4) & 63];
                if (!this.aza) {
                    return i28;
                }
                int i29 = i16 + 3;
                bArr2[i28] = Base64.padSymbol;
                int i30 = i16 + 4;
                bArr2[i29] = Base64.padSymbol;
                return i30;
            }
            int i31 = bArr[i25] & 255;
            bArr2[i27] = (byte) cArr[((i26 << 4) & 63) | (i31 >> 4)];
            int i32 = i16 + 3;
            bArr2[i16 + 2] = (byte) cArr[(i31 << 2) & 63];
            if (!this.aza) {
                return i32;
            }
            int i33 = i16 + 4;
            bArr2[i32] = Base64.padSymbol;
            return i33;
        }

        private final int de(int i10) {
            int i11;
            if (this.aza) {
                i11 = ((i10 + 2) / 3) * 4;
            } else {
                int i12 = i10 % 3;
                i11 = ((i10 / 3) * 4) + (i12 == 0 ? 0 : i12 + 1);
            }
            int i13 = this.ayZ;
            return i13 > 0 ? i11 + (((i11 - 1) / i13) * this.ayY.length) : i11;
        }

        public final byte[] encode(byte[] bArr) {
            int de2 = de(bArr.length);
            byte[] bArr2 = new byte[de2];
            int b10 = b(bArr, 0, bArr.length, bArr2);
            return b10 != de2 ? Arrays.copyOf(bArr2, b10) : bArr2;
        }

        public final String encodeToString(byte[] bArr) {
            byte[] encode = encode(bArr);
            return new String(encode, 0, 0, encode.length);
        }
    }

    public static b EW() {
        return b.ayU;
    }

    public static b EX() {
        return b.ayV;
    }

    public static a EY() {
        return a.ayN;
    }

    public static a EZ() {
        return a.ayP;
    }

    public static a Fa() {
        return a.ayO;
    }

    public static String dT(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "sDAkk/dS" + new String(EW().encode(str.getBytes()), com.kwad.sdk.crash.utils.a.UTF_8);
    }

    public static String dU(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("sDAkk/dS") ? new String(EY().decode(str.substring(8)), com.kwad.sdk.crash.utils.a.UTF_8) : str;
    }

    public static boolean dV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("sDAkk/dS");
    }

    public static class a {
        private static final int[] ayQ;
        private final boolean ayS;
        private final boolean ayT;
        static final a ayN = new a(false, false);
        static final a ayO = new a(true, false);
        static final a ayP = new a(false, true);
        private static final int[] ayR = new int[256];

        static {
            int[] iArr = new int[256];
            ayQ = iArr;
            Arrays.fill(iArr, -1);
            for (int i10 = 0; i10 < b.ayW.length; i10++) {
                ayQ[b.ayW[i10]] = i10;
            }
            ayQ[61] = -2;
            Arrays.fill(ayR, -1);
            for (int i11 = 0; i11 < b.ayX.length; i11++) {
                ayR[b.ayX[i11]] = i11;
            }
            ayR[61] = -2;
        }

        private a(boolean z10, boolean z11) {
            this.ayS = z10;
            this.ayT = z11;
        }

        private int a(byte[] bArr, int i10, int i11) {
            int i12;
            int[] iArr = this.ayS ? ayR : ayQ;
            int i13 = 0;
            if (i11 == 0) {
                return 0;
            }
            if (i11 < 2) {
                if (this.ayT && iArr[0] == -1) {
                    return 0;
                }
                throw new IllegalArgumentException("Input byte[] should at least have 2 bytes for base64 bytes");
            }
            if (this.ayT) {
                int i14 = 0;
                while (true) {
                    if (i10 >= i11) {
                        break;
                    }
                    int i15 = i10 + 1;
                    int i16 = bArr[i10] & 255;
                    if (i16 == 61) {
                        i11 -= (i11 - i15) + 1;
                        break;
                    }
                    if (iArr[i16] == -1) {
                        i14++;
                    }
                    i10 = i15;
                }
                i11 -= i14;
            } else if (bArr[i11 - 1] == 61) {
                i13 = bArr[i11 + (-2)] == 61 ? 2 : 1;
            }
            if (i13 == 0 && (i12 = i11 & 3) != 0) {
                i13 = 4 - i12;
            }
            return (((i11 + 3) / 4) * 3) - i13;
        }

        public final byte[] decode(byte[] bArr) {
            int a10 = a(bArr, 0, bArr.length);
            byte[] bArr2 = new byte[a10];
            int a11 = a(bArr, 0, bArr.length, bArr2);
            return a11 != a10 ? Arrays.copyOf(bArr2, a11) : bArr2;
        }

        public final byte[] decode(String str) {
            return decode(str.getBytes(c.ISO_8859_1));
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x002c, code lost:
        
            if (r12[r8] == 61) goto L139;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
        
            if (r4 != 18) goto L152;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
        
            if (r4 != 6) goto L154;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
        
            r15[r5] = (byte) (r3 >> 16);
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
        
            if (r13 >= r14) goto L177;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        
            if (r11.ayT == false) goto L178;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
        
            r15 = r13 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a7, code lost:
        
            if (r0[r12[r13]] >= 0) goto L176;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
        
            r13 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ab, code lost:
        
            r13 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00bf, code lost:
        
            throw new java.lang.IllegalArgumentException("Input byte array has incorrect ending byte at " + r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00c0, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
        
            if (r4 != 0) goto L156;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0088, code lost:
        
            r1 = r5 + 1;
            r15[r5] = (byte) (r3 >> 16);
            r5 = r5 + 2;
            r15[r1] = (byte) (r3 >> 8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        
            if (r4 == 12) goto L168;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00c8, code lost:
        
            throw new java.lang.IllegalArgumentException("Last unit does not have enough valid bits");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private int a(byte[] r12, int r13, int r14, byte[] r15) {
            /*
                Method dump skipped, instructions count: 201
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.a.c.a.a(byte[], int, int, byte[]):int");
        }
    }
}
