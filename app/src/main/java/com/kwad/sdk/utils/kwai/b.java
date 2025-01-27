package com.kwad.sdk.utils.kwai;

import com.vivo.advv.virtualview.common.ExprCommon;
import com.vivo.ic.dm.Downloads;
import java.nio.charset.Charset;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* loaded from: classes2.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aBN;
    public byte[] aBO;
    public int position;

    public b(int i2) {
        this(new byte[i2], 0);
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public b(byte[] bArr, int i2) {
        this.aBN = null;
        this.aBO = bArr;
        this.position = i2;
    }

    public static int ck(int i2) {
        if ((i2 >> 7) == 0) {
            return 1;
        }
        if ((i2 >> 14) == 0) {
            return 2;
        }
        if ((i2 >> 21) == 0) {
            return 3;
        }
        return (i2 >> 28) == 0 ? 4 : 5;
    }

    private char[] cm(int i2) {
        char[] cArr = this.aBN;
        if (cArr == null) {
            if (i2 <= 256) {
                this.aBN = new char[256];
            } else {
                this.aBN = new char[2048];
            }
        } else if (cArr.length < i2) {
            this.aBN = new char[2048];
        }
        return this.aBN;
    }

    private String cn(int i2) {
        if (i2 > 2048) {
            return new String(this.aBO, this.position, i2, UTF_8);
        }
        char[] cm = cm(i2);
        byte[] bArr = this.aBO;
        int i3 = this.position;
        int i4 = i2 + i3;
        int i5 = 0;
        while (i3 < i4) {
            int i6 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 > 0) {
                cm[i5] = (char) (b2 ^ 1);
                i3 = i6;
                i5++;
            } else if (b2 < -32) {
                cm[i5] = (char) (((b2 & 31) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i3 = i6 + 1;
                i5++;
            } else if (b2 < -16) {
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                cm[i5] = (char) (((b2 & 15) << 12) | ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE));
                i3 = i8;
                i5++;
            } else {
                int i9 = i6 + 1;
                int i10 = i9 + 1;
                int i11 = i10 + 1;
                int i12 = ((b2 & 7) << 18) | ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i9] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i10] & Utf8.REPLACEMENT_BYTE);
                int i13 = i5 + 1;
                cm[i5] = (char) ((i12 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i5 = i13 + 1;
                cm[i13] = (char) ((i12 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i3 = i11;
            }
        }
        if (i3 <= i4) {
            return new String(cm, 0, i5);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String co(int i2) {
        if (i2 > 2048) {
            return new String(this.aBO, this.position, i2, UTF_8);
        }
        char[] cm = cm(i2);
        byte[] bArr = this.aBO;
        int i3 = this.position;
        int i4 = i2 + i3;
        int i5 = 0;
        while (i3 < i4) {
            int i6 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 > 0) {
                cm[i5] = (char) b2;
                i3 = i6;
                i5++;
            } else if (b2 < -32) {
                cm[i5] = (char) (((b2 & 31) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i3 = i6 + 1;
                i5++;
            } else if (b2 < -16) {
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                cm[i5] = (char) (((b2 & 15) << 12) | ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i7] & Utf8.REPLACEMENT_BYTE));
                i3 = i8;
                i5++;
            } else {
                int i9 = i6 + 1;
                int i10 = i9 + 1;
                int i11 = i10 + 1;
                int i12 = ((b2 & 7) << 18) | ((bArr[i6] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i9] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i10] & Utf8.REPLACEMENT_BYTE);
                int i13 = i5 + 1;
                cm[i5] = (char) ((i12 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i5 = i13 + 1;
                cm[i13] = (char) ((i12 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i3 = i11;
            }
        }
        if (i3 <= i4) {
            return new String(cm, 0, i5);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public static int eY(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                i3++;
            } else if (charAt < 2048) {
                i3 += 2;
            } else if (charAt < 55296 || charAt > 57343) {
                i3 += 3;
            } else {
                i2 = i4 + 1;
                i3 += 4;
            }
            i2 = i4;
        }
        return i3;
    }

    private void eZ(String str) {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                bArr[i2] = (byte) (charAt ^ 1);
                i3 = i4;
                i2++;
            } else if (charAt < 2048) {
                int i5 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> 6) | Downloads.Impl.STATUS_RUNNING);
                i2 = i5 + 1;
                bArr[i5] = (byte) ((charAt & '?') | 128);
                i3 = i4;
            } else if (charAt < 55296 || charAt > 57343) {
                int i6 = i2 + 1;
                bArr[i2] = (byte) ((charAt >>> '\f') | 224);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i7] = (byte) ((charAt & '?') | 128);
                i3 = i4;
                i2 = i7 + 1;
            } else {
                int i8 = i4 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i4)) - 56613888;
                int i9 = i2 + 1;
                bArr[i2] = (byte) ((charAt2 >>> 18) | org.mozilla.universalchardet.prober.g.n);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i2 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & 63) | 128);
                i3 = i8;
            }
        }
        this.position = i2;
    }

    public static byte[] fa(String str) {
        byte[] bArr = new byte[eY(str)];
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                bArr[i3] = (byte) (charAt ^ 1);
                i2 = i4;
                i3++;
            } else if (charAt < 2048) {
                int i5 = i3 + 1;
                bArr[i3] = (byte) ((charAt >>> 6) | Downloads.Impl.STATUS_RUNNING);
                i3 = i5 + 1;
                bArr[i5] = (byte) ((charAt & '?') | 128);
                i2 = i4;
            } else if (charAt < 55296 || charAt > 57343) {
                int i6 = i3 + 1;
                bArr[i3] = (byte) ((charAt >>> '\f') | 224);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i7] = (byte) ((charAt & '?') | 128);
                i2 = i4;
                i3 = i7 + 1;
            } else {
                int i8 = i4 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i4)) - 56613888;
                int i9 = i3 + 1;
                bArr[i3] = (byte) ((charAt2 >>> 18) | org.mozilla.universalchardet.prober.g.n);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i3 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & 63) | 128);
                i2 = i8;
            }
        }
        return bArr;
    }

    private long getLong(int i2) {
        byte[] bArr = this.aBO;
        long j2 = bArr[i2] & 255;
        long j3 = j2 | ((bArr[r1] & 255) << 8);
        long j4 = j3 | ((bArr[r9] & 255) << 16);
        long j5 = j4 | ((bArr[r1] & 255) << 24);
        long j6 = j5 | ((bArr[r9] & 255) << 32);
        long j7 = j6 | ((bArr[r1] & 255) << 40);
        int i3 = i2 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        return (bArr[i3] << 56) | j7 | ((255 & bArr[r9]) << 48);
    }

    static String j(byte[] bArr, int i2) {
        char[] cArr = new char[bArr.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 > 0) {
                cArr[i4] = (char) (b2 ^ 1);
                i3 = i5;
                i4++;
            } else if (b2 < -32) {
                cArr[i4] = (char) (((b2 & 31) << 6) | (bArr[i5] & Utf8.REPLACEMENT_BYTE));
                i3 = i5 + 1;
                i4++;
            } else if (b2 < -16) {
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                cArr[i4] = (char) (((b2 & 15) << 12) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i6] & Utf8.REPLACEMENT_BYTE));
                i3 = i7;
                i4++;
            } else {
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                int i11 = ((b2 & 7) << 18) | ((bArr[i5] & Utf8.REPLACEMENT_BYTE) << 12) | ((bArr[i8] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i9] & Utf8.REPLACEMENT_BYTE);
                int i12 = i4 + 1;
                cArr[i4] = (char) ((i11 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                i4 = i12 + 1;
                cArr[i12] = (char) ((i11 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                i3 = i10;
            }
        }
        if (i3 <= i2) {
            return new String(cArr, 0, i4);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private int w(int i2, int i3) {
        while ((i3 & (-128)) != 0) {
            this.aBO[i2] = (byte) ((i3 & 127) | 128);
            i3 >>>= 7;
            i2++;
        }
        int i4 = i2 + 1;
        this.aBO[i2] = (byte) i3;
        return i4;
    }

    public final int Fc() {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        byte b2 = bArr[i2];
        if ((b2 >> 7) == 0) {
            return b2;
        }
        int i4 = b2 & ByteCompanionObject.MAX_VALUE;
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = i4 | (bArr[i3] << 7);
        if ((i6 >> 14) == 0) {
            return i6;
        }
        int i7 = i5 + 1;
        this.position = i7;
        int i8 = (i6 & 16383) | (bArr[i5] << 14);
        if ((i8 >> 21) == 0) {
            return i8;
        }
        int i9 = i7 + 1;
        this.position = i9;
        int i10 = (i8 & 2097151) | (bArr[i7] << ExprCommon.OPCODE_JMP);
        if ((i10 >> 28) == 0) {
            return i10;
        }
        this.position = i9 + 1;
        return (bArr[i9] << 28) | (i10 & 268435455);
    }

    public final void a(short s) {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) s;
        this.position = i3 + 1;
        bArr[i3] = (byte) (s >> 8);
    }

    public final void ai(long j2) {
        d(this.position, j2);
        this.position += 8;
    }

    public final void b(byte b2) {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b2;
    }

    public final void ci(int i2) {
        byte[] bArr = this.aBO;
        int i3 = this.position;
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) i2;
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (i2 >> 8);
        int i6 = i5 + 1;
        this.position = i6;
        bArr[i5] = (byte) (i2 >> 16);
        this.position = i6 + 1;
        bArr[i6] = (byte) (i2 >> 24);
    }

    public final void cj(int i2) {
        this.position = w(this.position, i2);
    }

    public final String cl(int i2) {
        if (i2 < 0) {
            return null;
        }
        if (i2 == 0) {
            return "";
        }
        String co = co(i2);
        this.position += i2;
        return co;
    }

    public final void d(int i2, long j2) {
        byte[] bArr = this.aBO;
        int i3 = i2 + 1;
        bArr[i2] = (byte) j2;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j2 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j2 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j2 >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j2 >> 32);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j2 >> 40);
        bArr[i8] = (byte) (j2 >> 48);
        bArr[i8 + 1] = (byte) (j2 >> 56);
    }

    public final void eX(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        eZ(str);
    }

    public final byte get() {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        this.position = i2 + 1;
        return bArr[i2];
    }

    public final byte[] getBytes(int i2) {
        byte[] bArr = new byte[i2];
        System.arraycopy(this.aBO, this.position, bArr, 0, i2);
        this.position += i2;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = bArr[i2] & 255;
        int i5 = i3 + 1;
        this.position = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        int i7 = i5 + 1;
        this.position = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 16);
        this.position = i7 + 1;
        return (bArr[i7] << ExprCommon.OPCODE_OR) | i8;
    }

    public final long getLong() {
        long j2 = getLong(this.position);
        this.position += 8;
        return j2;
    }

    public final short getShort() {
        byte[] bArr = this.aBO;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = bArr[i2] & 255;
        this.position = i3 + 1;
        return (short) ((bArr[i3] << 8) | i4);
    }

    public final String getString(int i2) {
        if (i2 < 0) {
            return null;
        }
        if (i2 == 0) {
            return "";
        }
        String cn = cn(i2);
        this.position += i2;
        return cn;
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.aBO, this.position, length);
            this.position += length;
        }
    }

    public final void v(int i2, int i3) {
        byte[] bArr = this.aBO;
        int i4 = i2 + 1;
        bArr[i2] = (byte) i3;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 8);
        bArr[i5] = (byte) (i3 >> 16);
        bArr[i5 + 1] = (byte) (i3 >> 24);
    }

    final long x(int i2, int i3) {
        long j2 = 0;
        if (i3 <= 0) {
            return 0L;
        }
        int i4 = i3 >> 3;
        int i5 = i3 & 7;
        int i6 = 0;
        int i7 = i2;
        for (int i8 = 0; i8 < i4; i8++) {
            j2 ^= getLong(i7);
            i7 += 8;
        }
        while (i6 < (i5 << 3)) {
            j2 ^= (this.aBO[i7] & 255) << i6;
            i6 += 8;
            i7++;
        }
        int i9 = (i2 & 7) << 3;
        return (j2 >>> (64 - i9)) | (j2 << i9);
    }
}
