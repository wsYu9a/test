package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import i5.c;
import i5.f;
import i5.h;
import i5.k;
import i5.m;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@Immutable
@h
/* loaded from: classes2.dex */
final class Murmur3_128HashFunction extends c implements Serializable {
    private static final long serialVersionUID = 0;
    private final int seed;
    static final k MURMUR3_128 = new Murmur3_128HashFunction(0);
    static final k GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f10050a);

    public static final class a extends f {

        /* renamed from: g */
        public static final int f10063g = 16;

        /* renamed from: h */
        public static final long f10064h = -8663945395140668459L;

        /* renamed from: i */
        public static final long f10065i = 5545529020109919103L;

        /* renamed from: d */
        public long f10066d;

        /* renamed from: e */
        public long f10067e;

        /* renamed from: f */
        public int f10068f;

        public a(int i10) {
            super(16);
            long j10 = i10;
            this.f10066d = j10;
            this.f10067e = j10;
            this.f10068f = 0;
        }

        public static long q(long j10) {
            long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
            long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
            return j12 ^ (j12 >>> 33);
        }

        public static long r(long j10) {
            return Long.rotateLeft(j10 * f10064h, 31) * f10065i;
        }

        public static long s(long j10) {
            return Long.rotateLeft(j10 * f10065i, 33) * f10064h;
        }

        @Override // i5.f
        public HashCode j() {
            long j10 = this.f10066d;
            int i10 = this.f10068f;
            long j11 = j10 ^ i10;
            long j12 = this.f10067e ^ i10;
            long j13 = j11 + j12;
            this.f10066d = j13;
            this.f10067e = j12 + j13;
            this.f10066d = q(j13);
            long q10 = q(this.f10067e);
            long j14 = this.f10066d + q10;
            this.f10066d = j14;
            this.f10067e = q10 + j14;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f10066d).putLong(this.f10067e).array());
        }

        @Override // i5.f
        public void m(ByteBuffer byteBuffer) {
            p(byteBuffer.getLong(), byteBuffer.getLong());
            this.f10068f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // i5.f
        public void n(ByteBuffer byteBuffer) {
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            long j15;
            long p10;
            this.f10068f += byteBuffer.remaining();
            long j16 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    j10 = 0;
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 2:
                    j11 = 0;
                    j10 = j11 ^ (UnsignedBytes.p(byteBuffer.get(1)) << 8);
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 3:
                    j12 = 0;
                    j11 = (UnsignedBytes.p(byteBuffer.get(2)) << 16) ^ j12;
                    j10 = j11 ^ (UnsignedBytes.p(byteBuffer.get(1)) << 8);
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 4:
                    j13 = 0;
                    j12 = j13 ^ (UnsignedBytes.p(byteBuffer.get(3)) << 24);
                    j11 = (UnsignedBytes.p(byteBuffer.get(2)) << 16) ^ j12;
                    j10 = j11 ^ (UnsignedBytes.p(byteBuffer.get(1)) << 8);
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 5:
                    j14 = 0;
                    j13 = j14 ^ (UnsignedBytes.p(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (UnsignedBytes.p(byteBuffer.get(3)) << 24);
                    j11 = (UnsignedBytes.p(byteBuffer.get(2)) << 16) ^ j12;
                    j10 = j11 ^ (UnsignedBytes.p(byteBuffer.get(1)) << 8);
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 6:
                    j15 = 0;
                    j14 = (UnsignedBytes.p(byteBuffer.get(5)) << 40) ^ j15;
                    j13 = j14 ^ (UnsignedBytes.p(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (UnsignedBytes.p(byteBuffer.get(3)) << 24);
                    j11 = (UnsignedBytes.p(byteBuffer.get(2)) << 16) ^ j12;
                    j10 = j11 ^ (UnsignedBytes.p(byteBuffer.get(1)) << 8);
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 7:
                    j15 = UnsignedBytes.p(byteBuffer.get(6)) << 48;
                    j14 = (UnsignedBytes.p(byteBuffer.get(5)) << 40) ^ j15;
                    j13 = j14 ^ (UnsignedBytes.p(byteBuffer.get(4)) << 32);
                    j12 = j13 ^ (UnsignedBytes.p(byteBuffer.get(3)) << 24);
                    j11 = (UnsignedBytes.p(byteBuffer.get(2)) << 16) ^ j12;
                    j10 = j11 ^ (UnsignedBytes.p(byteBuffer.get(1)) << 8);
                    p10 = j10 ^ UnsignedBytes.p(byteBuffer.get(0));
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 8:
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 9:
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 10:
                    j16 ^= UnsignedBytes.p(byteBuffer.get(9)) << 8;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 11:
                    j16 ^= UnsignedBytes.p(byteBuffer.get(10)) << 16;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(9)) << 8;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 12:
                    j16 ^= UnsignedBytes.p(byteBuffer.get(11)) << 24;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(10)) << 16;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(9)) << 8;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 13:
                    j16 ^= UnsignedBytes.p(byteBuffer.get(12)) << 32;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(11)) << 24;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(10)) << 16;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(9)) << 8;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 14:
                    j16 ^= UnsignedBytes.p(byteBuffer.get(13)) << 40;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(12)) << 32;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(11)) << 24;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(10)) << 16;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(9)) << 8;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                case 15:
                    j16 = UnsignedBytes.p(byteBuffer.get(14)) << 48;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(13)) << 40;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(12)) << 32;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(11)) << 24;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(10)) << 16;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(9)) << 8;
                    j16 ^= UnsignedBytes.p(byteBuffer.get(8));
                    p10 = byteBuffer.getLong();
                    this.f10066d = r(p10) ^ this.f10066d;
                    this.f10067e ^= s(j16);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        public final void p(long j10, long j11) {
            long r10 = r(j10) ^ this.f10066d;
            this.f10066d = r10;
            long rotateLeft = Long.rotateLeft(r10, 27);
            long j12 = this.f10067e;
            this.f10066d = ((rotateLeft + j12) * 5) + 1390208809;
            long s10 = s(j11) ^ j12;
            this.f10067e = s10;
            this.f10067e = ((Long.rotateLeft(s10, 31) + this.f10066d) * 5) + 944331445;
        }
    }

    public Murmur3_128HashFunction(int i10) {
        this.seed = i10;
    }

    @Override // i5.k
    public int bits() {
        return 128;
    }

    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.seed == ((Murmur3_128HashFunction) obj).seed;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // i5.k
    public m newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        int i10 = this.seed;
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append("Hashing.murmur3_128(");
        sb2.append(i10);
        sb2.append(")");
        return sb2.toString();
    }
}
