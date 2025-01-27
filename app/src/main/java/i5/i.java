package i5;

import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;

@h
/* loaded from: classes2.dex */
public final class i extends e {

    /* renamed from: b */
    public static final k f26897b = new i();

    /* renamed from: e */
    public static final long f26898e = -4348849565147123417L;

    /* renamed from: f */
    public static final long f26899f = -5435081209227447693L;

    /* renamed from: g */
    public static final long f26900g = -7286425919675154353L;

    @a5.d
    public static long a(byte[] bArr, int i10, int i11) {
        return i11 <= 32 ? i11 <= 16 ? b(bArr, i10, i11) : d(bArr, i10, i11) : i11 <= 64 ? e(bArr, i10, i11) : f(bArr, i10, i11);
    }

    public static long b(byte[] bArr, int i10, int i11) {
        if (i11 >= 8) {
            long j10 = (i11 * 2) + f26900g;
            long b10 = LittleEndianByteArray.b(bArr, i10) + f26900g;
            long b11 = LittleEndianByteArray.b(bArr, (i10 + i11) - 8);
            return c((Long.rotateRight(b11, 37) * j10) + b10, (Long.rotateRight(b10, 25) + b11) * j10, j10);
        }
        if (i11 >= 4) {
            return c(i11 + ((LittleEndianByteArray.a(bArr, i10) & 4294967295L) << 3), LittleEndianByteArray.a(bArr, (i10 + i11) - 4) & 4294967295L, (i11 * 2) + f26900g);
        }
        if (i11 <= 0) {
            return f26900g;
        }
        return g((((bArr[i10] & 255) + ((bArr[(i11 >> 1) + i10] & 255) << 8)) * f26900g) ^ ((i11 + ((bArr[i10 + (i11 - 1)] & 255) << 2)) * f26898e)) * f26900g;
    }

    public static long c(long j10, long j11, long j12) {
        long j13 = (j10 ^ j11) * j12;
        long j14 = ((j13 ^ (j13 >>> 47)) ^ j11) * j12;
        return (j14 ^ (j14 >>> 47)) * j12;
    }

    public static long d(byte[] bArr, int i10, int i11) {
        long j10 = (i11 * 2) + f26900g;
        long b10 = LittleEndianByteArray.b(bArr, i10) * f26899f;
        long b11 = LittleEndianByteArray.b(bArr, i10 + 8);
        int i12 = i10 + i11;
        long b12 = LittleEndianByteArray.b(bArr, i12 - 8) * j10;
        return c((LittleEndianByteArray.b(bArr, i12 - 16) * f26900g) + Long.rotateRight(b10 + b11, 43) + Long.rotateRight(b12, 30), b10 + Long.rotateRight(b11 + f26900g, 18) + b12, j10);
    }

    public static long e(byte[] bArr, int i10, int i11) {
        long j10 = (i11 * 2) + f26900g;
        long b10 = LittleEndianByteArray.b(bArr, i10) * f26900g;
        long b11 = LittleEndianByteArray.b(bArr, i10 + 8);
        int i12 = i10 + i11;
        long b12 = LittleEndianByteArray.b(bArr, i12 - 8) * j10;
        long rotateRight = Long.rotateRight(b10 + b11, 43) + Long.rotateRight(b12, 30) + (LittleEndianByteArray.b(bArr, i12 - 16) * f26900g);
        long c10 = c(rotateRight, b12 + Long.rotateRight(b11 + f26900g, 18) + b10, j10);
        long b13 = LittleEndianByteArray.b(bArr, i10 + 16) * j10;
        long b14 = LittleEndianByteArray.b(bArr, i10 + 24);
        long b15 = (rotateRight + LittleEndianByteArray.b(bArr, i12 - 32)) * j10;
        return c(((c10 + LittleEndianByteArray.b(bArr, i12 - 24)) * j10) + Long.rotateRight(b13 + b14, 43) + Long.rotateRight(b15, 30), b13 + Long.rotateRight(b14 + b10, 18) + b15, j10);
    }

    public static long f(byte[] bArr, int i10, int i11) {
        long j10 = 81;
        long j11 = (j10 * f26899f) + 113;
        long g10 = g((j11 * f26900g) + 113) * f26900g;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long b10 = (j10 * f26900g) + LittleEndianByteArray.b(bArr, i10);
        int i12 = i11 - 1;
        int i13 = i10 + ((i12 / 64) * 64);
        int i14 = i12 & 63;
        int i15 = i13 + i14;
        int i16 = i15 - 63;
        int i17 = i10;
        while (true) {
            long rotateRight = Long.rotateRight(b10 + j11 + jArr[0] + LittleEndianByteArray.b(bArr, i17 + 8), 37) * f26899f;
            long rotateRight2 = Long.rotateRight(j11 + jArr[1] + LittleEndianByteArray.b(bArr, i17 + 48), 42) * f26899f;
            long j12 = rotateRight ^ jArr2[1];
            long b11 = rotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr, i17 + 40);
            long rotateRight3 = Long.rotateRight(g10 + jArr2[0], 33) * f26899f;
            h(bArr, i17, jArr[1] * f26899f, j12 + jArr2[0], jArr);
            h(bArr, i17 + 32, rotateRight3 + jArr2[1], b11 + LittleEndianByteArray.b(bArr, i17 + 16), jArr2);
            int i18 = i17 + 64;
            if (i18 == i13) {
                long j13 = f26899f + ((j12 & 255) << 1);
                long j14 = jArr2[0] + i14;
                jArr2[0] = j14;
                long j15 = jArr[0] + j14;
                jArr[0] = j15;
                jArr2[0] = jArr2[0] + j15;
                long rotateRight4 = Long.rotateRight(rotateRight3 + b11 + jArr[0] + LittleEndianByteArray.b(bArr, i15 - 55), 37) * j13;
                long rotateRight5 = Long.rotateRight(b11 + jArr[1] + LittleEndianByteArray.b(bArr, i15 - 15), 42) * j13;
                long j16 = rotateRight4 ^ (jArr2[1] * 9);
                long b12 = rotateRight5 + (jArr[0] * 9) + LittleEndianByteArray.b(bArr, i15 - 23);
                long rotateRight6 = Long.rotateRight(j12 + jArr2[0], 33) * j13;
                h(bArr, i16, jArr[1] * j13, j16 + jArr2[0], jArr);
                h(bArr, i15 - 31, rotateRight6 + jArr2[1], b12 + LittleEndianByteArray.b(bArr, i15 - 47), jArr2);
                return c(c(jArr[0], jArr2[0], j13) + (g(b12) * f26898e) + j16, c(jArr[1], jArr2[1], j13) + rotateRight6, j13);
            }
            i17 = i18;
            g10 = j12;
            j11 = b11;
            b10 = rotateRight3;
        }
    }

    public static long g(long j10) {
        return j10 ^ (j10 >>> 47);
    }

    public static void h(byte[] bArr, int i10, long j10, long j11, long[] jArr) {
        long b10 = LittleEndianByteArray.b(bArr, i10);
        long b11 = LittleEndianByteArray.b(bArr, i10 + 8);
        long b12 = LittleEndianByteArray.b(bArr, i10 + 16);
        long b13 = LittleEndianByteArray.b(bArr, i10 + 24);
        long j12 = j10 + b10;
        long j13 = b11 + j12 + b12;
        long rotateRight = Long.rotateRight(j11 + j12 + b13, 21) + Long.rotateRight(j13, 44);
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
        return "Hashing.farmHashFingerprint64()";
    }
}
