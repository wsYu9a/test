package d3;

import com.tencent.bugly.beta.tinker.TinkerReport;
import okio.Utf8;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final int f25237a = 128;

    /* renamed from: b */
    public static final int f25238b = 64;

    /* renamed from: c */
    public static final int f25239c = 24;

    /* renamed from: d */
    public static final int f25240d = 8;

    /* renamed from: e */
    public static final int f25241e = 16;

    /* renamed from: f */
    public static final int f25242f = 4;

    /* renamed from: g */
    public static final int f25243g = -128;

    /* renamed from: h */
    public static final char f25244h = '=';

    /* renamed from: i */
    public static final byte[] f25245i = new byte[128];

    /* renamed from: j */
    public static final char[] f25246j = new char[64];

    static {
        int i10 = 0;
        for (int i11 = 0; i11 < 128; i11++) {
            f25245i[i11] = -1;
        }
        for (int i12 = 90; i12 >= 65; i12--) {
            f25245i[i12] = (byte) (i12 - 65);
        }
        for (int i13 = 122; i13 >= 97; i13--) {
            f25245i[i13] = (byte) (i13 - 71);
        }
        for (int i14 = 57; i14 >= 48; i14--) {
            f25245i[i14] = (byte) (i14 + 4);
        }
        byte[] bArr = f25245i;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i15 = 0; i15 <= 25; i15++) {
            f25246j[i15] = (char) (i15 + 65);
        }
        int i16 = 26;
        int i17 = 0;
        while (i16 <= 51) {
            f25246j[i16] = (char) (i17 + 97);
            i16++;
            i17++;
        }
        int i18 = 52;
        while (i18 <= 61) {
            f25246j[i18] = (char) (i10 + 48);
            i18++;
            i10++;
        }
        char[] cArr = f25246j;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (!f(cArr[i11])) {
                cArr[i10] = cArr[i11];
                i10++;
            }
        }
        return i10;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i10 = length % 24;
        int i11 = length / 24;
        char[] cArr = new char[(i10 != 0 ? i11 + 1 : i11) * 4];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            byte b10 = bArr[i12];
            int i15 = i12 + 2;
            byte b11 = bArr[i12 + 1];
            i12 += 3;
            byte b12 = bArr[i15];
            byte b13 = (byte) (b11 & 15);
            byte b14 = (byte) (b10 & 3);
            int i16 = b10 & Byte.MIN_VALUE;
            int i17 = b10 >> 2;
            if (i16 != 0) {
                i17 ^= 192;
            }
            byte b15 = (byte) i17;
            int i18 = b11 & Byte.MIN_VALUE;
            int i19 = b11 >> 4;
            if (i18 != 0) {
                i19 ^= 240;
            }
            byte b16 = (byte) i19;
            byte b17 = (byte) ((b12 & Byte.MIN_VALUE) == 0 ? b12 >> 6 : (b12 >> 6) ^ TinkerReport.KEY_LOADED_EXCEPTION_DEX);
            char[] cArr2 = f25246j;
            cArr[i13] = cArr2[b15];
            cArr[i13 + 1] = cArr2[b16 | (b14 << 4)];
            int i20 = i13 + 3;
            cArr[i13 + 2] = cArr2[(b13 << 2) | b17];
            i13 += 4;
            cArr[i20] = cArr2[b12 & Utf8.REPLACEMENT_BYTE];
        }
        if (i10 == 8) {
            byte b18 = bArr[i12];
            byte b19 = (byte) (b18 & 3);
            int i21 = b18 & Byte.MIN_VALUE;
            int i22 = b18 >> 2;
            if (i21 != 0) {
                i22 ^= 192;
            }
            byte b20 = (byte) i22;
            char[] cArr3 = f25246j;
            cArr[i13] = cArr3[b20];
            cArr[i13 + 1] = cArr3[b19 << 4];
            cArr[i13 + 2] = '=';
            cArr[i13 + 3] = '=';
        } else if (i10 == 16) {
            byte b21 = bArr[i12];
            byte b22 = bArr[i12 + 1];
            byte b23 = (byte) (b22 & 15);
            byte b24 = (byte) (b21 & 3);
            int i23 = b21 & Byte.MIN_VALUE;
            int i24 = b21 >> 2;
            if (i23 != 0) {
                i24 ^= 192;
            }
            byte b25 = (byte) i24;
            int i25 = b22 & Byte.MIN_VALUE;
            int i26 = b22 >> 4;
            if (i25 != 0) {
                i26 ^= 240;
            }
            byte b26 = (byte) i26;
            char[] cArr4 = f25246j;
            cArr[i13] = cArr4[b25];
            cArr[i13 + 1] = cArr4[b26 | (b24 << 4)];
            cArr[i13 + 2] = cArr4[b23 << 2];
            cArr[i13 + 3] = '=';
        }
        return new String(cArr);
    }

    public static boolean c(char c10) {
        return c10 < 128 && f25245i[c10] != -1;
    }

    public static byte[] d(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int a10 = a(charArray);
        if (a10 % 4 != 0) {
            return null;
        }
        int i10 = a10 / 4;
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10 * 3];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i10 - 1) {
            int i14 = i12 + 1;
            char c10 = charArray[i12];
            if (c(c10)) {
                int i15 = i12 + 2;
                char c11 = charArray[i14];
                if (c(c11)) {
                    int i16 = i12 + 3;
                    char c12 = charArray[i15];
                    if (c(c12)) {
                        i12 += 4;
                        char c13 = charArray[i16];
                        if (c(c13)) {
                            byte[] bArr2 = f25245i;
                            byte b10 = bArr2[c10];
                            byte b11 = bArr2[c11];
                            byte b12 = bArr2[c12];
                            byte b13 = bArr2[c13];
                            bArr[i13] = (byte) ((b10 << 2) | (b11 >> 4));
                            int i17 = i13 + 2;
                            bArr[i13 + 1] = (byte) (((b11 & 15) << 4) | ((b12 >> 2) & 15));
                            i13 += 3;
                            bArr[i17] = (byte) ((b12 << 6) | b13);
                            i11++;
                        }
                    }
                }
            }
            return null;
        }
        int i18 = i12 + 1;
        char c14 = charArray[i12];
        if (!c(c14)) {
            return null;
        }
        int i19 = i12 + 2;
        char c15 = charArray[i18];
        if (!c(c15)) {
            return null;
        }
        byte[] bArr3 = f25245i;
        byte b14 = bArr3[c14];
        byte b15 = bArr3[c15];
        char c16 = charArray[i19];
        char c17 = charArray[i12 + 3];
        if (c(c16) && c(c17)) {
            byte b16 = bArr3[c16];
            byte b17 = bArr3[c17];
            bArr[i13] = (byte) ((b14 << 2) | (b15 >> 4));
            bArr[i13 + 1] = (byte) (((b15 & 15) << 4) | ((b16 >> 2) & 15));
            bArr[i13 + 2] = (byte) (b17 | (b16 << 6));
            return bArr;
        }
        if (e(c16) && e(c17)) {
            if ((b15 & 15) != 0) {
                return null;
            }
            int i20 = i11 * 3;
            byte[] bArr4 = new byte[i20 + 1];
            System.arraycopy(bArr, 0, bArr4, 0, i20);
            bArr4[i13] = (byte) ((b14 << 2) | (b15 >> 4));
            return bArr4;
        }
        if (e(c16) || !e(c17)) {
            return null;
        }
        byte b18 = bArr3[c16];
        if ((b18 & 3) != 0) {
            return null;
        }
        int i21 = i11 * 3;
        byte[] bArr5 = new byte[i21 + 2];
        System.arraycopy(bArr, 0, bArr5, 0, i21);
        bArr5[i13] = (byte) ((b14 << 2) | (b15 >> 4));
        bArr5[i13 + 1] = (byte) (((b18 >> 2) & 15) | ((b15 & 15) << 4));
        return bArr5;
    }

    public static boolean e(char c10) {
        return c10 == '=';
    }

    public static boolean f(char c10) {
        return c10 == ' ' || c10 == '\r' || c10 == '\n' || c10 == '\t';
    }
}
