package i5;

import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;

@h
/* loaded from: classes2.dex */
public final class j extends e {

    /* renamed from: b */
    public static final k f26901b = new j();

    /* renamed from: e */
    public static final long f26902e = -6505348102511208375L;

    /* renamed from: f */
    public static final long f26903f = -8261664234251669945L;

    /* renamed from: g */
    public static final long f26904g = -4288712594273399085L;

    /* renamed from: h */
    public static final long f26905h = -4132994306676758123L;

    @a5.d
    public static long a(byte[] bArr, int i10, int i11) {
        long e10 = i11 <= 32 ? e(bArr, i10, i11, -1397348546323613475L) : i11 <= 64 ? d(bArr, i10, i11) : b(bArr, i10, i11);
        long j10 = f26902e;
        long b10 = i11 >= 8 ? LittleEndianByteArray.b(bArr, i10) : -6505348102511208375L;
        if (i11 >= 9) {
            j10 = LittleEndianByteArray.b(bArr, (i10 + i11) - 8);
        }
        long c10 = c(e10 + j10, b10);
        return (c10 == 0 || c10 == 1) ? c10 - 2 : c10;
    }

    public static long b(byte[] bArr, int i10, int i11) {
        long b10 = LittleEndianByteArray.b(bArr, i10);
        int i12 = i10 + i11;
        long b11 = LittleEndianByteArray.b(bArr, i12 - 16) ^ f26903f;
        long b12 = LittleEndianByteArray.b(bArr, i12 - 56) ^ f26902e;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j10 = i11;
        g(bArr, i12 - 64, j10, b11, jArr);
        g(bArr, i12 - 32, j10 * f26903f, f26902e, jArr2);
        long f10 = b12 + (f(jArr[1]) * f26903f);
        long rotateRight = Long.rotateRight(f10 + b10, 39) * f26903f;
        long rotateRight2 = Long.rotateRight(b11, 33) * f26903f;
        int i13 = i10;
        int i14 = (i11 - 1) & (-64);
        while (true) {
            long rotateRight3 = Long.rotateRight(rotateRight + rotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr, i13 + 16), 37) * f26903f;
            long rotateRight4 = Long.rotateRight(rotateRight2 + jArr[1] + LittleEndianByteArray.b(bArr, i13 + 48), 42) * f26903f;
            long j11 = rotateRight3 ^ jArr2[1];
            long j12 = rotateRight4 ^ jArr[0];
            long rotateRight5 = Long.rotateRight(f10 ^ jArr2[0], 33);
            g(bArr, i13, jArr[1] * f26903f, j11 + jArr2[0], jArr);
            g(bArr, i13 + 32, jArr2[1] + rotateRight5, j12, jArr2);
            i13 += 64;
            i14 -= 64;
            if (i14 == 0) {
                return c(c(jArr[0], jArr2[0]) + (f(j12) * f26903f) + j11, c(jArr[1], jArr2[1]) + rotateRight5);
            }
            rotateRight = rotateRight5;
            f10 = j11;
            rotateRight2 = j12;
        }
    }

    @a5.d
    public static long c(long j10, long j11) {
        long j12 = (j11 ^ j10) * f26905h;
        long j13 = (j10 ^ (j12 ^ (j12 >>> 47))) * f26905h;
        return (j13 ^ (j13 >>> 47)) * f26905h;
    }

    private static long d(byte[] bArr, int i10, int i11) {
        long b10 = LittleEndianByteArray.b(bArr, i10 + 24);
        int i12 = i10 + i11;
        int i13 = i12 - 16;
        long b11 = LittleEndianByteArray.b(bArr, i10) + ((i11 + LittleEndianByteArray.b(bArr, i13)) * f26902e);
        long rotateRight = Long.rotateRight(b11 + b10, 52);
        long rotateRight2 = Long.rotateRight(b11, 37);
        long b12 = b11 + LittleEndianByteArray.b(bArr, i10 + 8);
        long rotateRight3 = rotateRight2 + Long.rotateRight(b12, 7);
        int i14 = i10 + 16;
        long b13 = b12 + LittleEndianByteArray.b(bArr, i14);
        long j10 = b10 + b13;
        long rotateRight4 = rotateRight + Long.rotateRight(b13, 31) + rotateRight3;
        long b14 = LittleEndianByteArray.b(bArr, i14) + LittleEndianByteArray.b(bArr, i12 - 32);
        long b15 = LittleEndianByteArray.b(bArr, i12 - 8);
        long rotateRight5 = Long.rotateRight(b14 + b15, 52);
        long rotateRight6 = Long.rotateRight(b14, 37);
        long b16 = b14 + LittleEndianByteArray.b(bArr, i12 - 24);
        long rotateRight7 = rotateRight6 + Long.rotateRight(b16, 7);
        long b17 = b16 + LittleEndianByteArray.b(bArr, i13);
        return f((f(((j10 + rotateRight5 + Long.rotateRight(b17, 31) + rotateRight7) * f26904g) + ((b15 + b17 + rotateRight4) * f26902e)) * f26902e) + rotateRight4) * f26904g;
    }

    @a5.d
    public static long e(byte[] bArr, int i10, int i11, long j10) {
        int i12 = i11 & (-8);
        int i13 = i11 & 7;
        long j11 = j10 ^ (i11 * f26905h);
        for (int i14 = 0; i14 < i12; i14 += 8) {
            j11 = (j11 ^ (f(LittleEndianByteArray.b(bArr, i10 + i14) * f26905h) * f26905h)) * f26905h;
        }
        if (i13 != 0) {
            j11 = (LittleEndianByteArray.c(bArr, i10 + i12, i13) ^ j11) * f26905h;
        }
        return f(f(j11) * f26905h);
    }

    private static long f(long j10) {
        return j10 ^ (j10 >>> 47);
    }

    private static void g(byte[] bArr, int i10, long j10, long j11, long[] jArr) {
        long b10 = LittleEndianByteArray.b(bArr, i10);
        long b11 = LittleEndianByteArray.b(bArr, i10 + 8);
        long b12 = LittleEndianByteArray.b(bArr, i10 + 16);
        long b13 = LittleEndianByteArray.b(bArr, i10 + 24);
        long j12 = j10 + b10;
        long j13 = b11 + j12 + b12;
        long rotateRight = Long.rotateRight(j11 + j12 + b13, 51) + Long.rotateRight(j13, 23);
        jArr[0] = j13 + b13;
        jArr[1] = rotateRight + j12;
    }

    @Override // i5.k
    public int bits() {
        return 64;
    }

    @Override // i5.e, i5.c, i5.k
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        b5.u.f0(i10, i10 + i11, bArr.length);
        return HashCode.fromLong(a(bArr, i10, i11));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
