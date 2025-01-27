package com.sigmob.sdk.archives.tar;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public static final int f17582a = 255;

    public static long a(byte[] bArr) {
        long j10 = 0;
        for (byte b10 : bArr) {
            j10 += b10 & 255;
        }
        return j10;
    }

    public static int b(long j10, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 1;
        d(j10, bArr, i10, i12);
        bArr[i12 + i10] = 32;
        return i10 + i11;
    }

    public static int c(long j10, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 2;
        d(j10, bArr, i10, i12);
        bArr[i12 + i10] = 32;
        bArr[(i11 - 1) + i10] = 0;
        return i10 + i11;
    }

    public static void d(long j10, byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = i11 - 1;
        if (j10 == 0) {
            i12 = i11 - 2;
            bArr[i13 + i10] = e.E;
        } else {
            long j11 = j10;
            while (i13 >= 0 && j11 != 0) {
                bArr[i10 + i13] = (byte) (((byte) (7 & j11)) + e.E);
                j11 >>>= 3;
                i13--;
            }
            if (j11 != 0) {
                throw new IllegalArgumentException(j10 + "=" + Long.toOctalString(j10) + " will not fit in octal number buffer of length " + i11);
            }
            i12 = i13;
        }
        while (i12 >= 0) {
            bArr[i10 + i12] = e.E;
            i12--;
        }
    }

    public static String a(byte[] bArr, int i10, int i11, int i12, byte b10) {
        return "Invalid byte " + ((int) b10) + " at offset " + (i12 - i10) + " in '" + new String(bArr, i10, i11).replaceAll("\u0000", "{NUL}") + "' len=" + i11;
    }

    public static long b(byte[] bArr, int i10, int i11) {
        int i12 = i10 + i11;
        if (i11 < 2) {
            throw new IllegalArgumentException("Length " + i11 + " must be at least 2");
        }
        int i13 = i10;
        while (true) {
            long j10 = 0;
            if (i13 >= i12) {
                return 0L;
            }
            if (bArr[i13] != 0) {
                int i14 = i10;
                while (i14 < i12 && bArr[i14] == 32) {
                    i14++;
                }
                int i15 = i12 - 1;
                byte b10 = bArr[i15];
                if (b10 != 0 && b10 != 32) {
                    throw new IllegalArgumentException(a(bArr, i10, i11, i15, b10));
                }
                int i16 = i12 - 1;
                byte b11 = bArr[i12 - 2];
                if (b11 == 0 || b11 == 32) {
                    i16 = i12 - 2;
                }
                while (i14 < i16) {
                    byte b12 = bArr[i14];
                    if (b12 < 48 || b12 > 55) {
                        throw new IllegalArgumentException(a(bArr, i10, i11, i14, b12));
                    }
                    j10 = (j10 << 3) + (b12 - 48);
                    i14++;
                }
                return j10;
            }
            i13++;
        }
    }

    public static int a(long j10, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 2;
        d(j10, bArr, i10, i12);
        bArr[i12 + i10] = 0;
        bArr[(i11 - 1) + i10] = 32;
        return i10 + i11;
    }

    public static int a(String str, byte[] bArr, int i10, int i11) {
        int i12 = 0;
        while (i12 < i11 && i12 < str.length()) {
            bArr[i10 + i12] = (byte) str.charAt(i12);
            i12++;
        }
        while (i12 < i11) {
            bArr[i10 + i12] = 0;
            i12++;
        }
        return i10 + i11;
    }

    public static boolean a(byte[] bArr, int i10) {
        return bArr[i10] == 1;
    }

    public static String a(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer(i11);
        int i12 = i11 + i10;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (b10 == 0) {
                break;
            }
            stringBuffer.append((char) (b10 & 255));
            i10++;
        }
        return stringBuffer.toString();
    }
}
