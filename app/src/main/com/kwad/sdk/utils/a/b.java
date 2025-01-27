package com.kwad.sdk.utils.a;

import java.nio.charset.Charset;
import okio.Utf8;

/* loaded from: classes3.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aVX;
    public byte[] aVY;
    public int position;

    public b(int i10) {
        this(new byte[i10], 0);
    }

    private int C(int i10, int i11) {
        while ((i11 & d3.a.f25243g) != 0) {
            this.aVY[i10] = (byte) ((i11 & 127) | 128);
            i11 >>>= 7;
            i10++;
        }
        int i12 = i10 + 1;
        this.aVY[i10] = (byte) i11;
        return i12;
    }

    public static int eo(int i10) {
        if ((i10 >> 7) == 0) {
            return 1;
        }
        if ((i10 >> 14) == 0) {
            return 2;
        }
        if ((i10 >> 21) == 0) {
            return 3;
        }
        return (i10 >> 28) == 0 ? 4 : 5;
    }

    private char[] eq(int i10) {
        char[] cArr = this.aVX;
        if (cArr == null) {
            if (i10 <= 256) {
                this.aVX = new char[256];
            } else {
                this.aVX = new char[2048];
            }
        } else if (cArr.length < i10) {
            this.aVX = new char[2048];
        }
        return this.aVX;
    }

    private String er(int i10) {
        if (i10 > 2048) {
            return new String(this.aVY, this.position, i10, UTF_8);
        }
        char[] eq = eq(i10);
        byte[] bArr = this.aVY;
        int i11 = this.position;
        int i12 = i10 + i11;
        int i13 = 0;
        while (i11 < i12) {
            int i14 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 > 0) {
                eq[i13] = (char) (b10 ^ 1);
                i13++;
                i11 = i14;
            } else if (b10 < -32) {
                i11 += 2;
                byte b11 = bArr[i14];
                eq[i13] = (char) ((b11 & Utf8.REPLACEMENT_BYTE) | ((b10 & b5.a.I) << 6));
                i13++;
            } else if (b10 < -16) {
                int i15 = i11 + 2;
                byte b12 = bArr[i14];
                i11 += 3;
                byte b13 = bArr[i15];
                eq[i13] = (char) (((b12 & Utf8.REPLACEMENT_BYTE) << 6) | ((b10 & 15) << 12) | (b13 & Utf8.REPLACEMENT_BYTE));
                i13++;
            } else {
                byte b14 = bArr[i14];
                int i16 = i11 + 3;
                byte b15 = bArr[i11 + 2];
                i11 += 4;
                byte b16 = bArr[i16];
                int i17 = ((b14 & Utf8.REPLACEMENT_BYTE) << 12) | ((b10 & 7) << 18) | ((b15 & Utf8.REPLACEMENT_BYTE) << 6) | (b16 & Utf8.REPLACEMENT_BYTE);
                int i18 = i13 + 1;
                eq[i13] = (char) ((i17 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i13 += 2;
                eq[i18] = (char) ((i17 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i11 <= i12) {
            return new String(eq, 0, i13);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String es(int i10) {
        if (i10 > 2048) {
            return new String(this.aVY, this.position, i10, UTF_8);
        }
        char[] eq = eq(i10);
        byte[] bArr = this.aVY;
        int i11 = this.position;
        int i12 = i10 + i11;
        int i13 = 0;
        while (i11 < i12) {
            int i14 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 > 0) {
                eq[i13] = (char) b10;
                i13++;
                i11 = i14;
            } else if (b10 < -32) {
                i11 += 2;
                byte b11 = bArr[i14];
                eq[i13] = (char) ((b11 & Utf8.REPLACEMENT_BYTE) | ((b10 & b5.a.I) << 6));
                i13++;
            } else if (b10 < -16) {
                int i15 = i11 + 2;
                byte b12 = bArr[i14];
                i11 += 3;
                byte b13 = bArr[i15];
                eq[i13] = (char) (((b12 & Utf8.REPLACEMENT_BYTE) << 6) | ((b10 & 15) << 12) | (b13 & Utf8.REPLACEMENT_BYTE));
                i13++;
            } else {
                byte b14 = bArr[i14];
                int i16 = i11 + 3;
                byte b15 = bArr[i11 + 2];
                i11 += 4;
                byte b16 = bArr[i16];
                int i17 = ((b14 & Utf8.REPLACEMENT_BYTE) << 12) | ((b10 & 7) << 18) | ((b15 & Utf8.REPLACEMENT_BYTE) << 6) | (b16 & Utf8.REPLACEMENT_BYTE);
                int i18 = i13 + 1;
                eq[i13] = (char) ((i17 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i13 += 2;
                eq[i18] = (char) ((i17 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i11 <= i12) {
            return new String(eq, 0, i13);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private long getLong(int i10) {
        byte[] bArr = this.aVY;
        int i11 = i10 + 6;
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i11] & 255) << 48) | (bArr[i10 + 7] << 56);
    }

    public static int hr(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                i11++;
            } else if (charAt < 2048) {
                i11 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i11 += 3;
            } else {
                i10 += 2;
                i11 += 4;
            }
            i10 = i12;
        }
        return i11;
    }

    private void hs(String str) {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                bArr[i10] = (byte) (charAt ^ 1);
                i10++;
            } else if (charAt < 2048) {
                int i13 = i10 + 1;
                bArr[i10] = (byte) ((charAt >>> 6) | 192);
                i10 += 2;
                bArr[i13] = (byte) ((charAt & '?') | 128);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr[i10] = (byte) ((charAt >>> '\f') | 224);
                int i14 = i10 + 2;
                bArr[i10 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i10 += 3;
                bArr[i14] = (byte) ((charAt & '?') | 128);
            } else {
                i11 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i12)) - 56613888;
                bArr[i10] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i10 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i15 = i10 + 3;
                bArr[i10 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i10 += 4;
                bArr[i15] = (byte) ((charAt2 & 63) | 128);
            }
            i11 = i12;
        }
        this.position = i10;
    }

    public static byte[] ht(String str) {
        byte[] bArr = new byte[hr(str)];
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            char charAt = str.charAt(i10);
            if (charAt < 128) {
                bArr[i11] = (byte) (charAt ^ 1);
                i11++;
            } else if (charAt < 2048) {
                int i13 = i11 + 1;
                bArr[i11] = (byte) ((charAt >>> 6) | 192);
                i11 += 2;
                bArr[i13] = (byte) ((charAt & '?') | 128);
            } else if (charAt < 55296 || charAt > 57343) {
                bArr[i11] = (byte) ((charAt >>> '\f') | 224);
                int i14 = i11 + 2;
                bArr[i11 + 1] = (byte) (((charAt >>> 6) & 63) | 128);
                i11 += 3;
                bArr[i14] = (byte) ((charAt & '?') | 128);
            } else {
                i10 += 2;
                int charAt2 = ((charAt << '\n') + str.charAt(i12)) - 56613888;
                bArr[i11] = (byte) ((charAt2 >>> 18) | 240);
                bArr[i11 + 1] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i15 = i11 + 3;
                bArr[i11 + 2] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i11 += 4;
                bArr[i15] = (byte) ((charAt2 & 63) | 128);
            }
            i10 = i12;
        }
        return bArr;
    }

    public static String j(byte[] bArr, int i10) {
        char[] cArr = new char[bArr.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 > 0) {
                cArr[i12] = (char) (b10 ^ 1);
                i12++;
                i11 = i13;
            } else if (b10 < -32) {
                i11 += 2;
                byte b11 = bArr[i13];
                cArr[i12] = (char) ((b11 & Utf8.REPLACEMENT_BYTE) | ((b10 & b5.a.I) << 6));
                i12++;
            } else if (b10 < -16) {
                int i14 = i11 + 2;
                byte b12 = bArr[i13];
                i11 += 3;
                byte b13 = bArr[i14];
                cArr[i12] = (char) (((b12 & Utf8.REPLACEMENT_BYTE) << 6) | ((b10 & 15) << 12) | (b13 & Utf8.REPLACEMENT_BYTE));
                i12++;
            } else {
                byte b14 = bArr[i13];
                int i15 = i11 + 3;
                byte b15 = bArr[i11 + 2];
                i11 += 4;
                byte b16 = bArr[i15];
                int i16 = ((b14 & Utf8.REPLACEMENT_BYTE) << 12) | ((b10 & 7) << 18) | ((b15 & Utf8.REPLACEMENT_BYTE) << 6) | (b16 & Utf8.REPLACEMENT_BYTE);
                int i17 = i12 + 1;
                cArr[i12] = (char) ((i16 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i12 += 2;
                cArr[i17] = (char) ((i16 & 1023) + Utf8.LOG_SURROGATE_HEADER);
            }
        }
        if (i11 <= i10) {
            return new String(cArr, 0, i12);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public final void B(int i10, int i11) {
        byte[] bArr = this.aVY;
        bArr[i10] = (byte) i11;
        bArr[i10 + 1] = (byte) (i11 >> 8);
        bArr[i10 + 2] = (byte) (i11 >> 16);
        bArr[i10 + 3] = (byte) (i11 >> 24);
    }

    public final long D(int i10, int i11) {
        long j10 = 0;
        if (i11 <= 0) {
            return 0L;
        }
        int i12 = i11 >> 3;
        int i13 = i11 & 7;
        int i14 = 0;
        int i15 = i10;
        for (int i16 = 0; i16 < i12; i16++) {
            j10 ^= getLong(i15);
            i15 += 8;
        }
        while (i14 < (i13 << 3)) {
            j10 ^= (this.aVY[i15] & 255) << i14;
            i14 += 8;
            i15++;
        }
        int i17 = (i10 & 7) << 3;
        return (j10 >>> (64 - i17)) | (j10 << i17);
    }

    public final int Ps() {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        byte b10 = bArr[i10];
        if ((b10 >> 7) == 0) {
            return b10;
        }
        int i12 = i10 + 2;
        this.position = i12;
        int i13 = (bArr[i11] << 7) | (b10 & Byte.MAX_VALUE);
        if ((i13 >> 14) == 0) {
            return i13;
        }
        int i14 = i10 + 3;
        this.position = i14;
        int i15 = (i13 & 16383) | (bArr[i12] << 14);
        if ((i15 >> 21) == 0) {
            return i15;
        }
        int i16 = i10 + 4;
        this.position = i16;
        int i17 = (i15 & 2097151) | (bArr[i14] << b5.a.f1198y);
        if ((i17 >> 28) == 0) {
            return i17;
        }
        this.position = i10 + 5;
        return (bArr[i16] << b5.a.F) | (i17 & 268435455);
    }

    public final void a(short s10) {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        bArr[i10] = (byte) s10;
        this.position = i10 + 2;
        bArr[i11] = (byte) (s10 >> 8);
    }

    public final void aQ(long j10) {
        f(this.position, j10);
        this.position += 8;
    }

    public final void e(byte b10) {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        this.position = i10 + 1;
        bArr[i10] = b10;
    }

    public final void em(int i10) {
        byte[] bArr = this.aVY;
        int i11 = this.position;
        int i12 = i11 + 1;
        this.position = i12;
        bArr[i11] = (byte) i10;
        int i13 = i11 + 2;
        this.position = i13;
        bArr[i12] = (byte) (i10 >> 8);
        int i14 = i11 + 3;
        this.position = i14;
        bArr[i13] = (byte) (i10 >> 16);
        this.position = i11 + 4;
        bArr[i14] = (byte) (i10 >> 24);
    }

    public final void en(int i10) {
        this.position = C(this.position, i10);
    }

    public final String ep(int i10) {
        if (i10 < 0) {
            return null;
        }
        if (i10 == 0) {
            return "";
        }
        String es = es(i10);
        this.position += i10;
        return es;
    }

    public final void f(int i10, long j10) {
        byte[] bArr = this.aVY;
        bArr[i10] = (byte) j10;
        bArr[i10 + 1] = (byte) (j10 >> 8);
        bArr[i10 + 2] = (byte) (j10 >> 16);
        bArr[i10 + 3] = (byte) (j10 >> 24);
        bArr[i10 + 4] = (byte) (j10 >> 32);
        bArr[i10 + 5] = (byte) (j10 >> 40);
        bArr[i10 + 6] = (byte) (j10 >> 48);
        bArr[i10 + 7] = (byte) (j10 >> 56);
    }

    public final byte get() {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        this.position = i10 + 1;
        return bArr[i10];
    }

    public final byte[] getBytes(int i10) {
        byte[] bArr = new byte[i10];
        System.arraycopy(this.aVY, this.position, bArr, 0, i10);
        this.position += i10;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        int i15 = i10 + 3;
        this.position = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.position = i10 + 4;
        return (bArr[i15] << b5.a.B) | i16;
    }

    public final short getShort() {
        byte[] bArr = this.aVY;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        this.position = i10 + 2;
        return (short) ((bArr[i11] << 8) | i12);
    }

    public final String getString(int i10) {
        if (i10 < 0) {
            return null;
        }
        if (i10 == 0) {
            return "";
        }
        String er = er(i10);
        this.position += i10;
        return er;
    }

    public final void hq(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        hs(str);
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.aVY, this.position, length);
            this.position += length;
        }
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public final long getLong() {
        long j10 = getLong(this.position);
        this.position += 8;
        return j10;
    }

    public b(byte[] bArr, int i10) {
        this.aVX = null;
        this.aVY = bArr;
        this.position = i10;
    }
}
